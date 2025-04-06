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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the real path of the application for saving files
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + UPLOAD_DIR;

        // Create the upload directory if it doesn't exist
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        String fileName = null;

        // Process the uploaded file
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                String filePath = savePath + File.separator + fileName;
                part.write(filePath);

                try {
                    // Read the uploaded image
                    BufferedImage img = ImageIO.read(new File(filePath));
                    if (img == null) {
                        throw new IOException("Failed to read the image.");
                    }

                    // Analyze the image
                    String dominantColor = getDominantColor(img);
                    String colorPalette = getColorPalette(img);
                    String compositionAnalysis = analyzeRuleOfThirds(img);

                    // Set attributes for JSP
                    request.setAttribute("imagePath", UPLOAD_DIR + "/" + fileName);
                    request.setAttribute("dominantColor", dominantColor != null ? dominantColor : "#ffffff");
                    request.setAttribute("colorPalette", colorPalette != null ? colorPalette : "#ffffff");
                    request.setAttribute("compositionAnalysis", compositionAnalysis != null ? compositionAnalysis : "No analysis available.");

                    // Forward to result page
                    request.getRequestDispatcher("/result.jsp").forward(request, response);
                    return;
                } catch (IOException e) {
                    System.out.println("Error processing image: " + e.getMessage());
                    response.getWriter().println("Error: Failed to process the uploaded image.");
                    return;
                }
            }
        }

        response.getWriter().println("No file uploaded.");
    }

    /**
     * Extracts the file name from the content-disposition header of a Part object.
     */
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

    /**
     * Calculates the dominant color of an image.
     */
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

    /**
     * Generates a color palette using K-Means clustering.
     */
    private String getColorPalette(BufferedImage img) {
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

        KMeansPlusPlusClusterer<Clusterable> clusterer = new KMeansPlusPlusClusterer<>(5);
        List<CentroidCluster<Clusterable>> clusters = clusterer.cluster(points);

        StringBuilder colorPalette = new StringBuilder();
        for (CentroidCluster<Clusterable> cluster : clusters) {
            double[] center = cluster.getCenter().getPoint();
            int r = (int) center[0];
            int g = (int) center[1];
            int b = (int) center[2];
            String hexColor = String.format("#%02x%02x%02x", r, g, b);
            colorPalette.append(hexColor).append(" ");
        }

        return colorPalette.toString().trim();
    }

    /**
     * Analyzes the image for Rule of Thirds composition using edge detection.
     */
    private String analyzeRuleOfThirds(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int thirdWidth = width / 3;
        int thirdHeight = height / 3;

        boolean[][] edgeMap = detectEdges(img);

        boolean hasHorizontalLines = checkForEdges(edgeMap, thirdHeight - 5, thirdHeight + 5, true, width, height);
        boolean hasVerticalLines = checkForEdges(edgeMap, thirdWidth - 5, thirdWidth + 5, false, width, height);

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

    /**
     * Detects edges in the image using a simple gradient-based approach.
     */
    private boolean[][] detectEdges(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        boolean[][] edgeMap = new boolean[height][width];

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                Color center = new Color(img.getRGB(x, y));
                Color left = new Color(img.getRGB(x - 1, y));
                Color right = new Color(img.getRGB(x + 1, y));
                Color top = new Color(img.getRGB(x, y - 1));
                Color bottom = new Color(img.getRGB(x, y + 1));

                int gx = (right.getRed() - left.getRed()) + 2 * (right.getGreen() - left.getGreen()) + (right.getBlue() - left.getBlue());
                int gy = (bottom.getRed() - top.getRed()) + 2 * (bottom.getGreen() - top.getGreen()) + (bottom.getBlue() - top.getBlue());

                if (Math.sqrt(gx * gx + gy * gy) > 100) {
                    edgeMap[y][x] = true;
                }
            }
        }
        return edgeMap;
    }

    /**
     * Checks for significant edges along the rule of thirds lines.
     */
    private boolean checkForEdges(boolean[][] edgeMap, int start, int end, boolean horizontal, int width, int height) {
        for (int i = start; i <= end; i++) {
            int count = 0;
            if (horizontal) {
                for (int x = 0; x < width; x++) {
                    if (i >= 0 && i < height && edgeMap[i][x]) count++;
                }
            } else {
                for (int y = 0; y < height; y++) {
                    if (i >= 0 && i < width && edgeMap[y][i]) count++;
                }
            }
            int threshold = Math.max(10, (horizontal ? width : height) / 20);
            if (count > threshold) {
                return true;
            }
        }
        return false;
    }
}