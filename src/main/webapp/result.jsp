<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Image Analysis Results</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Blanka&display=swap" rel="stylesheet">
    <!-- Linking the external CSS and JS files -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="css/result.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="navbar-container">
            <a href="#" class="navbar-logo">Tri Matic</a>
            <div class="navbar-toggle" id="mobile-menu">
                <span class="bar"></span>
                <span class="bar"></span>
                <span class="bar"></span>
            </div>
            <ul class="navbar-menu">
                <li class="navbar-item">
                    <a href="index.html" class="navbar-link">Home</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="navbar-link" id="aboutButton">About</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="navbar-link" id="servicesButton">Services</a>
                </li>
                <li class="navbar-item">
                    <a href="#downside" class="navbar-link">Contact</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container">
        <!-- Glowing Border -->
        <div class="animated-border-box-glow"></div>
        <div class="animated-border-box"></div>
        <!-- Content -->
        <div class="content">
            <h1>Image Analysis Results</h1>

            <!-- Uploaded Image -->
            <img src="<%= request.getAttribute("imagePath") != null ? request.getAttribute("imagePath") : "" %>" 
                 alt="Uploaded Image" 
                 class="image">

            <!-- Dominant Color -->
            <h2>Dominant Color</h2>
            <div style="display: flex; justify-content: center;">
                <div class="color-box" 
                     style="background-color: <%= request.getAttribute("dominantColor") != null ? request.getAttribute("dominantColor") : "#ffffff" %>;" 
                     data-color="<%= request.getAttribute("dominantColor") != null ? request.getAttribute("dominantColor") : "#ffffff" %>" 
                     onclick="copyToClipboard(this)">
                </div>
            </div>

            <hr style="border: 1;height: 0;margin: auto;margin-top: 50px;border-style: dashed;border-color: rgba(255, 255, 255, 0.2);">
            <!-- Color Palette -->
            <h2>Color Palette</h2>
            <div class="color-palette">
                <% 
                    String colorPalette = (String) request.getAttribute("colorPalette");
                    if (colorPalette != null && !colorPalette.isEmpty()) {
                        String[] colors = colorPalette.split(" ");
                        for (String color : colors) { 
                %>
                            <div class="color-box" 
                                 style="background-color: <%= color %>;" 
                                 data-color="<%= color %>" 
                                 onclick="copyToClipboard(this)">
                            </div>
                <% 
                        }
                    } else { 
                %>
                        <p>No color palette available.</p>
                <% 
                    } 
                %>
            </div>
            
            <hr style="border: 1;height: 0;margin: auto;margin-top: 55px;border-style: dashed;border-color: rgba(255, 255, 255, 0.2);">
            <!-- Rule of Thirds Analysis -->
            <h2>Composition Analysis</h2>
            <p><%= request.getAttribute("compositionAnalysis") != null ? request.getAttribute("compositionAnalysis") : "No analysis available." %></p>

            <div style="border: 1px dashed #f1cb01;border-style: dashed;border-radius: 9px;">
                <p style="font-size: small;">The <b>Rule of Thirds</b> is a compositional guideline suggesting that an image can be divided into nine equal parts by two horizontal and two vertical lines. Placing important elements along these lines or their intersections is thought to be visually pleasing. You can learn more about it <a href="https://en.wikipedia.org/wiki/Rule_of_thirds" class="link" target = "_blank">here</a>.</p>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal" id="modal">
        <div class="modal-content">
            <span class="close-button" id="closeButton">&times;</span>
            <div id="modalContent"></div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <div class="footer-container" id = "downside">
            <!-- Follow Us Section -->
            <div class="footer-social">
                <h3>Contact Me</h3>
                <div class="social-icons">
                    <a href="mailto:nikhilsingh9597@gmail.com" class="social-icon" target="_blank" title="Send me an email"><i class="fas fa-envelope"></i></a>
                    <a href="https://www.linkedin.com/in/nikhilthesingh/" target="_blank" class="social-icon"><i class="fab fa-linkedin-in" title="Connect with me on Linkedin"></i></a>
                    <a href="https://www.instagram.com/nikhilthesingh?igsh=MTBoeDFmNDZzcm0wMg==" target="_blank" class="social-icon"><i class="fab fa-instagram" title="Connect with me on Instagram"></i></a>
                    <a href="https://github.com/nikhilthesingh" target="_blank" class="social-icon"><i class="fab fa-github" title="Follow me on GitHub"></i></a>
                    <a href="https://trimatic.carrd.co/" target="_blank" class="social-icon"><i class="fas fa-briefcase" title="Video Edits and Graphic Design"></i></a>
                </div>
            </div>
        </div>
        <!-- Copyright -->
        <div class="footer-copyright">
            <p>&copy; 2024 Nikhil Kumar. All rights reserved.</p>
        </div>
    </footer>

    <script src="js/result-page.js"></script>
</body>
</html>