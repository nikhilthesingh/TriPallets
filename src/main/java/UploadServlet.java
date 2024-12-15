import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.apache.commons.math3.ml.clustering.DoublePoint;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 5, // 5 MB
        maxRequestSize = 1024 * 1024 * 10) // 10 MB
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + UPLOAD_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                String filePath = savePath + File.separator + fileName;
                part.write(filePath);

                // Analyze the image
                BufferedImage img = ImageIO.read(new File(filePath));
                String dominantColor = getDominantColor(img);
                String colorPalette = getColorPalette(img);
                String compositionAnalysis = analyzeRuleOfThirds(img);

                // Set attributes for JSP (if needed for result display)
                request.setAttribute("imagePath", UPLOAD_DIR + "/" + fileName);
                request.setAttribute("dominantColor", dominantColor);
                request.setAttribute("colorPalette", colorPalette);
                request.setAttribute("compositionAnalysis", compositionAnalysis);

                // Forward to a result page (if needed)
                request.getRequestDispatcher("/result.jsp").forward(request, response);
                return;
            }
        }
        response.getWriter().println("No file uploaded");
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }

    private String getDominantColor(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        long totalR = 0, totalG = 0, totalB = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x, y));
                totalR += color.getRed();
                totalG += color.getGreen();
                totalB += color.getBlue();
            }
        }

        int pixelCount = width * height;
        int avgR = (int) (totalR / pixelCount);
        int avgG = (int) (totalG / pixelCount);
        int avgB = (int) (totalB / pixelCount);
        return String.format("#%02x%02x%02x", avgR, avgG, avgB); // Return hex code of average color
    }

    private String getColorPalette(BufferedImage img) {
        // Prepare data for KMeans clustering
        List<Clusterable> points = new ArrayList<>();
        int width = img.getWidth();
        int height = img.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                Color color = new Color(rgb);
                points.add(new DoublePoint(new double[]{color.getRed(), color.getGreen(), color.getBlue()}));
            }
        }

        // Perform KMeans clustering
        KMeansPlusPlusClusterer<Clusterable> clusterer = new KMeansPlusPlusClusterer<>(5);
        List<CentroidCluster<Clusterable>> clusters = clusterer.cluster(points);

        // Get cluster centers
        StringBuilder colorPalette = new StringBuilder();
        for (CentroidCluster<Clusterable> cluster : clusters) {
            double[] center = cluster.getCenter().getPoint();
            int r = (int) center[0];
            int g = (int) center[1];
            int b = (int) center[2];
            String hexColor = String.format("#%02x%02x%02x", r, g, b);
            colorPalette.append(hexColor).append(" ");
        }

        return colorPalette.toString();
    }

    private String analyzeRuleOfThirds(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int thirdWidth = width / 3;
        int thirdHeight = height / 3;

        boolean hasHorizontalLines = false;
        for (int y = thirdHeight - 5; y <= thirdHeight + 5; y++) {
            int whitePixelCount = 0;
            for (int x = 0; x < width; x++) {
                if (img.getRGB(x, y) == Color.WHITE.getRGB()) {
                    whitePixelCount++;
                }
            }
            if (whitePixelCount > (width / 5)) {
                hasHorizontalLines = true;
                break;
            }
        }

        boolean hasVerticalLines = false;
        for (int x = thirdWidth - 5; x <= thirdWidth + 5; x++) {
            int whitePixelCount = 0;
            for (int y = 0; y < height; y++) {
                if (img.getRGB(x, y) == Color.WHITE.getRGB()) {
                    whitePixelCount++;
                }
            }
            if (whitePixelCount > (height / 5)) {
                hasVerticalLines = true;
                break;
            }
        }

        String analysis;
        if (hasHorizontalLines && hasVerticalLines) {
            analysis = "The image has elements following the Rule of Thirds with both horizontal and vertical lines near the thirds.";
        } else if (hasHorizontalLines) {
            analysis = "The image has elements following the Rule of Thirds with horizontal lines near the thirds.";
        } else if (hasVerticalLines) {
            analysis = "The image has elements following the Rule of Thirds with vertical lines near the thirds.";
        } else {
            analysis = "The image does not have strong evidence of following the Rule of Thirds.";
        }

        return analysis;
    }
}
