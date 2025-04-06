// Navbar Toggle for Mobile
const mobileMenu = document.getElementById('mobile-menu');
const navbarMenu = document.querySelector('.navbar-menu');
mobileMenu.addEventListener('click', () => {
    navbarMenu.classList.toggle('active');
});

// File Input and Preview Logic
const fileInput = document.getElementById('fileInput');
const fileName = document.getElementById('fileName');
const previewContainer = document.getElementById('previewContainer');
const previewImage = document.getElementById('previewImage');

fileInput.addEventListener('change', function(e) {
    if (e.target.files.length) {
        const file = e.target.files[0];
        if (file.size > 5 * 1024 * 1024) {
            alert('File size exceeds 5MB. Please choose a smaller file.');
            fileInput.value = '';
            resetPreview();
            return;
        }
        fileName.textContent = `Selected: ${file.name}`;
        fileName.classList.add('show');
        previewContainer.style.display = 'flex';
        previewImage.src = URL.createObjectURL(file);
        previewImage.alt = file.name;
        document.querySelector('.upload-container').style.height = 'auto';
    }
});

function resetPreview() {
    fileName.textContent = '';
    fileName.classList.remove('show');
    previewContainer.style.display = 'none';
    previewImage.src = '#';
    previewImage.alt = '';
}

// Show loader and blurred background on form submit
const uploadForm = document.getElementById('uploadForm');
const loader = document.getElementById('loader');
const blurBackground = document.getElementById('blurBackground');

uploadForm.addEventListener('submit', function() {
    loader.style.display = 'block';
    blurBackground.style.display = 'block';
});

// Hide loader and blurred background after file upload is complete
uploadForm.addEventListener('load', function() {
    loader.style.display = 'none';
    blurBackground.style.display = 'none';
});

// Modal Logic
const aboutButton = document.getElementById('aboutButton');
const servicesButton = document.getElementById('servicesButton');
const modal = document.getElementById('modal');
const closeButton = document.getElementById('closeButton');
const modalContent = document.getElementById('modalContent');

aboutButton.addEventListener('click', () => {
    modalContent.innerHTML = 	`
	               <div style="font-family: 'Montserrat', sans-serif; line-height: 1.6; color: #FFFFFF; text-align: left;">
	                   <h2 style="font-size: 1.8rem; margin-bottom: 20px; color: #FFD700;">Hi, I’m Nikhil Kumar</h2>
	                   <p style="font-size: 1rem; margin-bottom: 20px;">
	                       A Computer Science Engineering student who’s building his own empire while acing assignments and debugging life along the way. You’ll usually find me juggling between Java classes and real-life client calls, sipping chai while brainstorming digital strategies, and occasionally convincing my code to behave like a responsible adult.
	                   </p>
	                   <div style="text-align: left; max-width: 500px; margin: 0 auto;">
	                       <div style="margin-bottom: 20px;">
	                           <h3 style="color: #FFA500; font-size: 1.2rem; margin-bottom: 8px;">💻 Tech Stack? More Like a Buffet!</h3>
	                           <ul style="list-style-type: disc; padding-left: 20px; font-size: 1rem; margin-bottom: 15px;">
	                               <li><strong>Java & Python:</strong> Solid grip on Java (can write code faster than I text), and Python has been my go-to since Class 11.</li>
	                               <li><strong>C & C++:</strong> C taught me discipline, and now I’m upgrading my arsenal with C++ (because why stop at good when you can be great?).</li>
	                               <li><strong>SQL & Oracle Database:</strong> I don’t just store data; I know how to make it dance. Currently diving into Oracle DB to level up my database game.</li>
	                               <li><strong>HTML, CSS, jQuery:</strong> I can craft sleek and functional websites that don’t just look pretty but also work like a charm.</li>
	                               <li><strong>JavaScript & React (In Progress!):</strong> Right now, I’m taming JavaScript and gearing up to conquer React, because front-end magic is next on my hit list.</li>
	                           </ul>
	                       </div>
	                       <div style="margin-bottom: 20px;">
	                           <h3 style="color: #FFA500; font-size: 1.2rem; margin-bottom: 8px;">🚀 Tri Matic: Where Hustle Meets Creativity</h3>
	                           <p>What started as a side hustle is now <strong>Tri Matic</strong> — a powerhouse of video and graphic editing, where creativity meets precision. I built this agency from scratch, also added a few passionate guys on this mission, and now we’re a team that’s delivered impactful content for big and known players. From punchy news reels to visually stunning graphics, we create content that makes people pause mid-scroll.</p>
	                       </div>
	                       <div style="margin-bottom: 20px;">
	                           <h3 style="color: #FFA500; font-size: 1.2rem; margin-bottom: 8px;">🎨 The Color Palette Tool? Oh, I Built That!</h3>
	                           <p>When life gives me a college project, I turn it into something that adds real value. Enter the <strong>Color Palette Extractor Tool</strong> — a sleek web app that extracts color schemes from images, ensuring brand consistency across designs. This wasn’t just a submission; it’s now a core tool that keeps Tri Matic’s visuals on point.</p>
	                       </div>
	                       <div style="margin-bottom: 20px;">
	                           <h3 style="color: #FFA500; font-size: 1.2rem; margin-bottom: 8px;">💡 What’s Cooking Next?</h3>
	                           <p>I’m not just chasing grades — I’m chasing growth. Learning Oracle DB to deep dive into enterprise-level databases, mastering C++ to unlock more powerful algorithms, and gearing up to ace React so I can dominate the front-end game. And when I’m not coding, I’m strategizing how to take Tri Matic to the next level.</p>
	                       </div>
	                       <p style="font-size: 1rem; margin-top: 25px; font-style: italic;">
	                           In short — I’m a student, entrepreneur, and tech junkie who thrives on solving problems and creating impact. And trust me, this journey is just getting started. 😎🔥
	                       </p>
	                   </div>
	               </div>
	           `;
    modal.style.display = 'flex';
});

servicesButton.addEventListener('click', () => {
    modalContent.innerHTML = `
        <h2 style="font-size: 1.8rem; margin-bottom: 20px; color: #FFD700;">Our Services 💡</h2>
        <p style="font-size: 1rem; margin-bottom: 20px;">
            👉 Check Out Our Portfolio: <a href="https://trimatic.carrd.co/" target="_blank" style="color: #FFD700; text-decoration: underline;">trimatic.carrd.co</a>
        </p>
        <p style="font-size: 1rem; margin-bottom: 25px;">
            At Tri Matic, we don’t just do services — we make your brand look slick and your content hit harder than a viral meme. Here’s what’s on the menu:
        </p>
        <div style="text-align: left; max-width: 500px; margin: 0 auto;">
            <div style="margin-bottom: 20px;">
                <h3 style="color: #FFD700; font-size: 1.2rem; margin-bottom: 8px;">🎥 Video Editing That Slaps</h3>
                <p>From crisp reels to cinematic cuts, we turn raw footage into scroll-stopping masterpieces. Whether it’s snappy Instagram edits or full-blown YouTube bangers, we’ve got the sauce.</p>
            </div>
            <div style="margin-bottom: 20px;">
                <h3 style="color: #FFD700; font-size: 1.2rem; margin-bottom: 8px;">🎨 Graphic Design That Pops</h3>
                <p>Forget boring graphics — we create visuals that scream "Look at me!" Posters, banners, thumbnails — we make sure your brand stands out like a neon sign in a blackout.</p>
            </div>
            <div style="margin-bottom: 20px;">
                <h3 style="color: #FFD700; font-size: 1.2rem; margin-bottom: 8px;">📱 Social Media Management (SMMA)</h3>
                <p>We’re not just posting — we’re building brands. Killer content, smart strategies, and engaging captions that make people stick around. Growth? That’s just the beginning.</p>
            </div>
            <div style="margin-bottom: 20px;">
                <h3 style="color: #FFD700; font-size: 1.2rem; margin-bottom: 8px;">🎬 YouTube Channel Management</h3>
                <p>From scripting to uploading, we handle it all. Thumbnails that get clicks, titles that drive views, and content that keeps people binge-watching.</p>
            </div>
            <div style="margin-bottom: 20px;">
                <h3 style="color: #FFD700; font-size: 1.2rem; margin-bottom: 8px;">🌈 Color Palette Tool for Perfect Brand Consistency</h3>
                <p>Consistency = Credibility. Our custom-built Color Palette Extractor Tool ensures your brand colors stay sharp and aligned across all platforms. No guesswork, just perfection.</p>
            </div>
            <div style="margin-bottom: 20px;">
                <h3 style="color: #FFD700; font-size: 1.2rem; margin-bottom: 8px;">🚀 Custom Growth Solutions for Digital Domination</h3>
                <p>Every brand’s different, and we treat it that way. We offer tailored solutions to help you scale, grow, and leave your competition in the dust.</p>
            </div>
            <p style="font-size: 1rem; margin-top: 25px; font-style: italic;">
                ⚡️ Ready to make magic happen? Let’s talk.<br>
                Because at Tri Matic, we don’t just create content — we build impact. 💥
            </p>
        </div>
    `;
    modal.style.display = 'flex';
});

closeButton.addEventListener('click', () => {
    modal.style.display = 'none';
});

window.addEventListener('click', (event) => {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
});

// Add drag-and-drop hover effect logic
       const dropZone = document.getElementById('dropZone');

       dropZone.addEventListener('dragover', (e) => {
           e.preventDefault();
           dropZone.classList.add('dragover');
       });

       dropZone.addEventListener('dragleave', () => {
           dropZone.classList.remove('dragover');
       });
       dropZone.addEventListener('dragover', (e) => {
           e.preventDefault();
           dropZone.classList.add('dragover');
           dropZone.querySelector('.upload-label').textContent = 'Drop the file here';
       });

       dropZone.addEventListener('dragleave', () => {
           dropZone.classList.remove('dragover');
           dropZone.querySelector('.upload-label').textContent = 'Choose File';
       });

       dropZone.addEventListener('drop', (e) => {
           e.preventDefault();
           dropZone.classList.remove('dragover');
           dropZone.querySelector('.upload-label').textContent = 'Choose File';

           if (e.dataTransfer.files.length) {
               const file = e.dataTransfer.files[0];
               if (file.type.startsWith('image/')) {
                   if (file.size > 5 * 1024 * 1024) {
                       alert('File size exceeds 5MB. Please choose a smaller file.');
                       return;
                   }
                   fileInput.files = e.dataTransfer.files; // Assign dropped file to input
                   fileName.textContent = `Selected: ${file.name}`;
                   fileName.classList.add('show');
                   previewContainer.style.display = 'flex';
                   previewImage.src = URL.createObjectURL(file);
                   previewImage.alt = file.name;
               } else {
                   alert('Please drop a valid image file.');
               }
           }
       });
