# 🎨 **Color Palette Extractor Tool**  
### *Your Personal Magic Wand for Extracting Colors and Dominating Designs!*

---

## 🚀 **About the Project**  
Ever stared at a picture and wondered, *"What are these stunning colors?"* Or struggled to figure out the **dominant color** of an image? 🎨  

This tool is here to save the day! Upload an image, and **BOOM**—it extracts **5 beautiful colors** (with their HEX codes) and highlights the **dominant color**. It doesn’t stop there—our **Rule of Thirds feature** ensures you never miss creating perfectly balanced designs again!  

Perfect for **designers**, **developers**, **photographers**, and anyone who lives and breathes colors 🌈.

---
## 📸 **Screenshots**
-  **Home Page**
  
 ![alt text](https://github.com/nikhilthesingh/TriPallets/blob/master/Screenshot%202024-12-16%20021202.png?raw=true)

-  **Color Palette Output Page** 
  
 ![alt text](https://github.com/nikhilthesingh/TriPallets/blob/master/Screenshot%202024-12-16%20021318.png?raw=true)

---
## 🛠️ **Features**  
- 📤 **Upload Any Image**: Supports popular formats like JPEG and PNG.  
- 🎨 **Extract 5 Dominant Colors**: Instantly displays the top 5 colors from the image along with their HEX codes.  
- 🟣 **Identify the Dominant Color**: Highlights the **most prominent color** in the image.  
- 📐 **Rule of Thirds**: Automatically divides the image into a grid to help you create balanced, professional designs.  
- ⚡ **Quick Results**: Get everything instantly—no lag, no fuss.  
- 💾 **User-Friendly UI**: Clean, simple interface anyone can use.  

---

## 🌟 **Why This Tool is a Life-Saver**  
- 🎯 **Designers**: Choose the perfect colors for your UI/UX designs, logos, or posters without guessing.  
- 🖌️ **Photographers**: Use the Rule of Thirds grid to find balanced and aesthetic photo compositions.  
- 🎬 **Content Creators**: Plan video thumbnails, Instagram posts, or marketing graphics with accurate and appealing colors.  
- 👨‍💻 **Developers**: Get exact HEX codes for your websites and apps—no more color mismatches.  

> *This tool saves time, boosts creativity, and solves real-world design problems, all while being fun to use!*  

---

## 👶 **How to Run the Project** (Simplified for Beginners)  
Follow these easy steps to run the project locally:

### **Step 1: Prerequisites**  
Make sure you have the following installed:  
- **Java Development Kit (JDK)** - [Download here](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html).  
- **Apache Tomcat Server** (For running the Java Servlets).  
- Any **IDE** (e.g., Eclipse, IntelliJ) for better development experience.  

---

### **Step 2: Clone the Repository** 🧩  
Copy the project to your system:  
```bash
git clone https://github.com/yourusername/ColorPaletteTool.git
cd ColorPaletteTool 
```

### **Step 3: Add Dependencies 📦**   
Place the required libraries (JAR files) into the project directory:
- Apache Commons Math → Download and add it to WEB-INF/lib.
- Servlet API JAR (if needed for Tomcat).
> *You can find these libraries online or via Maven/Gradle.*

### **Step 4: Deploy the Project 🚦🧩  
- Run the project on Tomcat Server.
- Access it through your browser:  
```bash
http://localhost:8080/ColorPaletteTool 
```

---

##  **⚙️ How it Works**  
# 🧩 **For Beginners:**
- Upload an Image → The app reads the image pixels.
- Color Extraction → Using K-Means Clustering, it groups similar colors and picks the top 5.
- Dominant Color → The most frequent color in the clusters is highlighted as dominant.
- Rule of Thirds Grid → The image is divided into 9 equal parts for visual balance.


# **💻 For Pros:**
1.Color Extraction:

- We use K-Means Clustering (via Apache Commons Math) to group similar pixel values into k clusters, where k=5.
- The algorithm minimizes the distance between pixel values and their respective cluster centers.
- Final cluster centers represent the dominant colors.

2.Dominant Color:
- After clustering, we determine the largest cluster (highest pixel count) as the dominant color.

3.Rule of Thirds Grid:
- Mathematically divides the image into a 3x3 grid, overlaying vertical and horizontal lines.
- Ensures focal points align with intersections to achieve balanced designs.

4.Backend Logic:
- Java Servlets handle the image upload and processing.
- Apache Commons Math library performs K-Means clustering.
- Grid logic is rendered dynamically over the uploaded image.

---
## 🐛 Troubleshooting

### 🚨 Common Issues

| Problem                   | Solution                                                   |
|---------------------------|------------------------------------------------------------|
| **Server not starting**   | Check if Tomcat is configured correctly.                   |
| **Missing JAR files**     | Ensure all required JARs are in `WEB-INF/lib`.             |
| **Port Conflict**         | Change Tomcat's port in `server.xml`.                      |
| **Page not loading**      | Verify your project URL is `http://localhost:8080/YourProject`. |
| **Deployment Errors**     | Rebuild and redeploy the project on Tomcat.                |
