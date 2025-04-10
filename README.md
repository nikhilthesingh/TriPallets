# 🎨 **Color Palette Extractor Tool (Version 2.0)**  
### *Your Ultimate Sidekick for Mastering Colors and Composition!*  

---

## 🚀 **About Project's Version 2.0**  
Ever gazed at an image and thought, *"What’s making these colors pop?"* or wondered how to perfect its composition? 🎨 'TriPallets Version 2.0' is your answer—an upgraded powerhouse that takes image analysis to the next level! Upload an image and watch it extract a **5-color palette**, pinpoint the **dominant color**, and analyze the **Rule of Thirds** with next-level smarts—all wrapped in a fresh, slick design.  

Here’s what it brings to the table:  
- 📤 **Image Upload**: Drop or pick JPEGs/PNGs (max 5MB) with a live preview.  
- 🎨 **5-Color Palette**: Extracts five stunning colors with HEX codes—copy them in a snap!  
- 🟣 **Dominant Color**: Highlights the image’s standout shade with precision.  
- 📐 **Rule of Thirds**: Analyzes composition like a pro—perfectly balanced designs await.  
- ✨ **Polished UI**: Responsive, fast, and gorgeous on any device.  
- ⚡ **Quick Results**: No lag—just instant creative fuel.  

This is your go-to for design, photography, and creative brilliance 🌈—now better than ever!  

*Note*: This is the latest evolution of Tri Matic. Curious about the original? Check the [main README](https://github.com/nikhilthesingh/TriPallets/tree/master) for both versions!  

---

## 🌟 **What’s New in Version 2.0**  
Version 2.0 takes it up a notch—here’s how it shines brighter than Version 1.0:  
- **Mobile-Friendly Design**: Now responsive with a slick navbar—works like a charm on phones too!  
- **Drag-and-Drop Upload**: Ditch the old form for seamless uploads with real-time previews.  
- **Copy-to-Clipboard Colors**: Click to snag HEX codes instantly—no more manual copying.  
- **Edge-Based Rule of Thirds**: Smarter analysis ditches white pixels for precise edge detection.  
- **UI Glow-Up**: Glowing borders, modals, and a loader make it look and feel pro.  

These upgrades mean sharper results, smoother use, and a tool that fits your screen—big or small!  

---

## 📸 **Screenshots**  
See Version 2.0 in action!  

- **Live Demo (GIF)**  
 ![Image](https://github.com/user-attachments/assets/dc3b7107-c508-4ab0-a43e-a8d128d58c2b)
 *Watch the magic unfold—from upload to results!*  

- **Upload Page with Drag-and-Drop**  
  ![Upload Page](https://github.com/nikhilthesingh/TriPallets/blob/version-2.0/upload_page.png?raw=true)  
  *Sleek drag-and-drop with a glowing twist!*  

- **Results Page with Copyable Colors**  
  ![Results Page](https://github.com/nikhilthesingh/TriPallets/blob/version-2.0/results_page.png?raw=true)  
  *Click to copy HEX codes and see edge-based analysis!*  

*Note*: Upload the GIF and screenshots to the `version-2.0` branch, then update these paths if needed!  

---

## 🌟 **Why This Tool is a Game-Changer**  
- 🎯 **Designers**: Nail brand palettes and UI vibes with clickable HEX codes—no more guesswork, even on mobile.  
- 🖌️ **Photographers**: Perfect your shots with pro-level Rule of Thirds insights, anywhere.  
- 🎬 **Content Creators**: Craft eye-catching thumbnails or posts with colors that pop, on the go.  
- 👨‍💻 **Developers**: Snag exact HEX codes for your projects in a heartbeat, from any device.  

> *Version 2.0 saves time, boosts creativity, and turns ideas into reality—your designs will thank you, desktop or mobile!*  

---

## ⚙️ **How It Works**  
### 🧩 **For Beginners**  
- Upload an Image → Drop it in and see it come alive.  
- Color Extraction → Five gorgeous colors pop up with HEX codes—copy them with a click!  
- Dominant Color → The tool finds the image’s standout shade.  
- Rule of Thirds → A smart grid shows you how balanced it is—easy peasy!  

### 💻 **For Pros**  
1. **Color Extraction**:  
   - Uses K-Means Clustering (Apache Commons Math3) to group pixels into 5 clusters.  
   - Outputs HEX codes from cluster centers—now with copy-to-clipboard flair.  
2. **Dominant Color**:  
   - Averages RGB values across all pixels for a spot-on result.  
3. **Rule of Thirds**:  
   - Edge detection algorithm scans for key lines, aligning them with a 3x3 grid—way more accurate than Version 1.0’s white pixel method.  
4. **Backend Power**:  
   - Java Servlets crunch the data, JSP pages show it off, and JavaScript adds the responsive sparkle.  

---

## 🛠️ **Tech Stack**  
Version 2.0 is built to impress—here’s the magic behind it:  

| **Layer / Purpose**           | **Technology Used**               | **Description**                                                                 |
|-------------------------------|-----------------------------------|---------------------------------------------------------------------------------|
| **Frontend (UI)**             | HTML, CSS, JSP, JavaScript        | Brings the glow with a navbar, drag-and-drop, modals, and mobile responsiveness. |
| **Backend (Server-Side)**     | Java (Servlets)                   | Handles uploads, processes images, and crunches the numbers.                    |
| **Web Framework**             | Java Servlet API                  | Powers dynamic responses—smooth as butter!                                      |
| **Image Processing**          | Apache Commons Math3 (K-Means)    | Clusters pixels like a pro for palettes and dominant colors.                    |
| **Build Setup**               | Eclipse IDE (Dynamic Web Project) | Keeps everything tidy with WebContent, WEB-INF, and src.                        |
| **Web Server**                | Apache Tomcat 9+                  | Runs the show with rock-solid reliability.                                      |

---

## 👶 **How to Install**  
Good news—Version 2.0 runs on the same setup as Version 1.0! Get it going with:  
1. Clone it: `git clone -b version-2.0 https://github.com/nikhilthesingh/TriPallets`.  
2. Open in Eclipse as a Dynamic Web Project.  
3. Hook up Tomcat 9.0 and hit `Run on Server`.  
4. Visit `http://localhost:8080/TriPallets-V2/`—boom, you’re live!  

*Need the full scoop? Check the step-by-step guide in the [Version 1.0 README](https://github.com/nikhilthesingh/TriPallets/tree/version-1.0#-how-to-run-the-project-step-by-step-guide).*  

---

## 🐛 **Troubleshooting**  
Stuck? Here’s the quick fix lineup:  
- **404 Page?**: Double-check `http://localhost:8080/TriPallets` and redeploy.  
- **Upload Flop?**: Keep images under 5MB and ensure the `uploads/` folder’s there.  
- **Tomcat Tantrum?**: Switch port 8080 to 8081 if it’s busy.  

*For the full troubleshooting playbook, dive into the [Version 1.0 README](https://github.com/nikhilthesingh/TriPallets/tree/version-1.0#-troubleshooting).*  

---

## 👨‍💻 **About the Developer**  
Crafted by [Nikhil Kumar](https://github.com/nikhilthesingh), a CSE student and the mastermind behind Tri Matic—a creative tech venture that’s all about blending code and design. Want more? Peek at [trimatic.carrd.co](https://trimatic.carrd.co/).  
