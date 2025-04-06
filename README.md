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
  
 ![alt text](https://github.com/nikhilthesingh/TriPallets/blob/version-1.0/Screenshot%202024-12-16%20021202.png?raw=true)

-  **Color Palette Output Page** 
  
 ![alt text](https://github.com/nikhilthesingh/TriPallets/blob/version-1.0/Screenshot%202024-12-16%20021318.png?raw=true)

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

## 👶 How to Run the Project (Step-by-Step Guide)

Follow these steps to set up and run the Tri Matic Color Palette Extractor Tool locally. This guide is tailored for Eclipse IDE with Java EE perspective and Apache Tomcat 9.0—perfect for beginners and pros alike!

### Step 1: Prerequisites

Before you begin, ensure you have the following installed on your system:

- **Java Development Kit (JDK)**: Version 8 or higher. [Download here](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Eclipse IDE for Enterprise Java Developers**: Preferred for this project. [Download here](https://www.eclipse.org/downloads/packages/).
- **Apache Tomcat 9.0**: The server to run the web app. [Download here](https://tomcat.apache.org/download-90.cgi).
  - Need help installing Tomcat? Watch this [YouTube tutorial](https://www.youtube.com/watch?v=-bxT-yEJww8) for a step-by-step guide.

**Note**: Using Eclipse with the Java EE perspective is recommended for the smoothest experience.

### Step 2: Set Up Eclipse with Java EE Perspective

1. Open Eclipse IDE.
2. Switch to the **Java EE perspective**:
   - Go to `Window > Perspective > Open Perspective > Other > Java EE`.
   - If you’re new to this, check out this [YouTube tutorial](https://www.youtube.com/watch?v=mxZ_DsnCBmA) for guidance.
3. Ensure Tomcat is configured in Eclipse:
   - Go to `Window > Preferences > Server > Runtime Environments`.
   - Click `Add`, select `Apache Tomcat v9.0`, and point to your Tomcat installation directory.
   - Click `Finish` and `Apply and Close`.

### Step 3: Download and Import the Project

1. **Download the Repository**:
   - Clone it using Git:
```bash
git clone https://github.com/nikhilthesingh/TriPallets.git
cd TriPallets 
```
- Or download the ZIP file from GitHub and extract it to a folder (e.g., `C:\Projects\TriPallets`).

2. **Import into Eclipse**:
- In Eclipse, go to `File > Open Projects from File System`.
- Click `Directory`, navigate to the extracted `TriPallets` folder, and select it.
- Click `Finish` to import the project into your workspace.

### Step 4: Run the Project on Tomcat

1. In the Project Explorer, locate the `TriPallets` folder.
2. Right-click the project and select `Run As > Run on Server`.
3. In the dialog:
- Choose your configured `Tomcat v9.0 Server`.
- Click `Finish`.
4. Eclipse will deploy the project to Tomcat, and your default browser should automatically open to:
```bash
http://localhost:8080/TriPallets
```
- If it doesn’t, manually open this URL in your browser.

### Step 5: Test It Out!

- On the home page, upload an image (JPEG or PNG, max 5MB).
- Watch the magic happen as the tool extracts colors and analyzes composition!

### Optional: Check Dependencies (If Issues Arise)

The project already includes required JAR files (e.g., Apache Commons Math) in the `WEB-INF/lib` folder. If you encounter errors like "ClassNotFoundException" or the project doesn’t run as expected:
- Verify the `WEB-INF/lib` folder contains `commons-math3-*.jar` and `javax.servlet-api-4.0.1.jar`.
- If missing, download it from [Apache Commons Math](https://mvnrepository.com/artifact/org.apache.commons/commons-math3/3.6.1) and [Java Servlet API](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api/4.0.1).
- Copy the JAR to `TriPallets > WEB-INF > lib` in Eclipse’s Project Explorer.
- Refresh the project (right-click `TriPallets > Refresh`) and redeploy.

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
- Calculated as the average RGB value across all pixels for a simple, effective representation.

3.Rule of Thirds Grid:
- Mathematically divides the image into a 3x3 grid, overlaying vertical and horizontal lines.
- Ensures focal points align with intersections to achieve balanced designs.

4.Backend Logic:
- Java Servlets handle the image upload and processing.
- Apache Commons Math library performs K-Means clustering.
- Results are forwarded to a JSP page for display.

---
## 🐛 Troubleshooting

### 🚨 Common Issues

| Problem                       | Possible Cause                                  | Solution                                                                                   |
|-------------------------------|------------------------------------------------|--------------------------------------------------------------------------------------------|
| **"404 Page Not Found"**      | Project not deployed or wrong URL              | - Ensure the URL is `http://localhost:8080/TriPallets`.<br>- Right-click the project in Project Explorer > `Run As > Run on Server` to redeploy.<br>- Check if Tomcat is running (look for the green "play" icon in the Servers tab). |
| **Tomcat won’t start**        | Server misconfigured or port conflict          | - Verify Tomcat is added in `Window > Preferences > Server > Runtime Environments`.<br>- Check `conf/server.xml` in Tomcat folder; change `<Connector port="8080" ...>` to another port (e.g., 8081) if 8080 is in use.<br>- Restart Eclipse and Tomcat (right-click server in Servers tab > `Restart`). |
| **"ClassNotFoundException"**  | Missing or corrupted JAR files                 | - Check `WEB-INF/lib` for `commons-math3-*.jar` and `javax.servlet-api-*.jar`.<br>- If missing, see "Optional: Check Dependencies" above.<br>- Right-click project > `Refresh` (F5) to reload files.<br>- Clean project: `Project > Clean > Select TriPallets > OK`. |
| **Project not deploying**     | Build errors or stale deployment               | - Clean and rebuild: `Project > Clean > Select TriPallets > OK`.<br>- In Servers tab, right-click Tomcat > `Clean` to clear old deployment.<br>- Redeploy: Right-click project > `Run As > Run on Server`. |
| **Browser doesn’t open**      | Eclipse didn’t launch browser automatically    | - Manually open `http://localhost:8080/TriPallets` in your browser.<br>- Ensure `Run on Server` completed (check Console tab for errors).<br>- Check Eclipse settings: `Window > Preferences > General > Web Browser` and select your default browser. |
| **Upload fails silently**     | Image too large or server issue                | - Ensure image is <5MB (max file size).<br>- Check Console tab in Eclipse for errors.<br>- Restart Tomcat: Servers tab > right-click server > `Restart`.<br>- Verify `uploads` folder exists in project root (create it if missing). |
| **"Server already in use"**   | Another process using port 8080                | - Open Command Prompt/Terminal, run `netstat -aon | findstr :8080` (Windows) or `lsof -i :8080` (Mac/Linux) to find the process ID (PID).<br>- Kill it: `taskkill /PID <number>` (Windows) or `kill -9 <PID>` (Mac/Linux).<br>- Or change Tomcat port in `server.xml` to 8081. |
| **Changes not reflecting**    | Cached files or server not refreshed           | - Refresh project: Right-click `TriPallets` > `Refresh` (F5).<br>- Clean Tomcat: Servers tab > right-click server > `Clean`.<br>- Restart server: Right-click server > `Restart`.<br>- Clear browser cache (Ctrl+Shift+Delete). |

### Quick Tips
- **Check the Console**: Eclipse’s Console tab often shows error messages—read it first!
- **Restart Everything**: If stuck, restart Tomcat (Servers tab > `Restart`) and Eclipse.
