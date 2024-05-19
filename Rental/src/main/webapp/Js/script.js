document.addEventListener("DOMContentLoaded", function(event) {
    var images = document.querySelectorAll(".slider-image");
    var currentIndex = 0;
    var interval;
  
    // Function to show the current image
    function showImage(index) {
      // Clear the interval to stop the automatic sliding
      clearInterval(interval);
  
      // Hide all images
      for (var i = 0; i < images.length; i++) {
        images[i].style.transform = "translateX(100%)";
      }
  
      // Show the selected image
      images[index].style.transform = "translateX(0)";
  
      // Update the current index
      currentIndex = index;
  
      // Restart the slider after 5 seconds
      interval = setInterval(function() {
        currentIndex = (currentIndex + 1) % images.length;
        showImage(currentIndex);
      }, 5000);
    }
  
    // Function to start the slider
    function startSlider() {
      interval = setInterval(function() {
        currentIndex = (currentIndex + 1) % images.length;
        showImage(currentIndex);
      }, 3000);
    }
  
    // Start the slider
    startSlider();
    
  });