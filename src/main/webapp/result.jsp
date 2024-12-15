<!DOCTYPE html>
<html>
<head>
    <title>Image Analysis Results</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Montserrat', sans-serif;
            background: linear-gradient(to bottom, #000000, #FFA500);
            color: #FFFFFF;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background-color: rgba(0, 0, 0, 0.8);
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            max-width: 800px;
            width: 100%;
            text-align: center;
        }
        h1 {
            color: #FFA500;
        }
        .image {
            margin: 20px 0;
            max-width: 500px;
            width: 100%;
        }
        .color-box {
            display: inline-block;
            width: 40px;
            height: 40px;
            margin: 0 10px;
            vertical-align: middle;
            border-radius: 4px;
        }
        .color-text {
            display: inline-block;
            vertical-align: middle;
        }
        .section {
            margin: 20px 0;
        }
        .link {
            color: #FFA500;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Image Analysis Results</h1>
        <img src="<%= request.getAttribute("imagePath") %>" class="image" alt="Uploaded Image">
        <div class="section">
            <h2>Dominant Color:</h2>
            <div class="color-box" style="background-color: <%= request.getAttribute("dominantColor") %>;"></div>
            <span class="color-text"><%= request.getAttribute("dominantColor") %></span>
        </div>
        <div class="section">
            <h2>Color Palette:</h2>
            <%
                String colorPalette = (String) request.getAttribute("colorPalette");
                String[] colors = colorPalette.split(" ");
                for (String color : colors) {
            %>
                <div class="color-box" style="background-color: <%= color %>;"></div>
                <span class="color-text"><%= color %></span>
            <% } %>
        </div>
        <div class="section">
            <h2>Rule of Thirds Analysis:</h2>
            <p><%= request.getAttribute("compositionAnalysis") %></p>
            <p>The Rule of Thirds is a compositional guideline suggesting that an image can be divided into nine equal parts by two horizontal and two vertical lines. Placing important elements along these lines or their intersections is thought to be visually pleasing. You can learn more about it <a href="https://en.wikipedia.org/wiki/Rule_of_thirds" class="link">here</a>.</p>
        </div>
    </div>
</body>
</html>
