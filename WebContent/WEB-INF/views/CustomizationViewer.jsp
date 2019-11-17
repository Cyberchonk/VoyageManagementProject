<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
   <link rel="stylesheet" href="resources/css/RegistrationViewer.css">
</head>

<body>

   <div class="header">
      <img class = "ImageGallery" src="resources/img/PVFukushima.jpg">
      <a href="dashboard">
	     <img class="logo" src="resources/img/Picture2.png" style="margin-left: 4%; width: 25%">
	  </a>  

   </div>

   
   
   <form action="customizepackage" method="POST">
     <div class="container">
       <h1 style="font-family: Arial, Helvetica, sans-serif;">Customize Your Own Package</h1>
       <p style="font-family: Arial, Helvetica, sans-serif;">Please fill in this form to create a package.</p>
       <hr>

       <label for="city"><b>Destination</b></label>
       <input type="text" placeholder="Where do you want to go ?" name="cityname" required>
	   
	   <label for="hotel"><b>Hotel</b></label>
       <input type="text" placeholder="Which hotel would you like to stay at ?" name="hotel">
	   
	   <label for="date"><b>Departure Date</b></label>
       <input type="text" placeholder="When do you want to depart ?" type="date" min='2019-05-17' max='2020-06-01' name="date" required>
	   
	   <label for="duration"><b>Duration</b></label>
       <input type="text" placeholder="How many days would you like to stay? *" name="duration" pattern="[0-9]{1,2}">
	   
	   <label for="budget"><b>Budget</b></label>
       <input type="text" placeholder="Do you have a budget in mind ?" name="budget" pattern="[0-9]{3,}">

       <label for="comment"><b>Comments</b></label>
       <input type="text" placeholder="Any additional requirement ?" name="comment">
	   
       <hr>

       <button type="submit" class="registerbtn" style="font-size:20px;">Create</button>
     </div>
  
   </form>

   

   <footer class="footer-distributed">

		<div class="footer-left" style="width:30%">

        <image class="logo-bottom" src="resources/img/Picture2.png" style="margin-left: 2%; width: 100%"> 

			<p class="footer-links">
				<a href="Solo Project.html">Home</a>
				
				<a href="#">Packages</a>
				
				<a href="#">Customize</a>
				
				<a href="#">About</a>
				
				<a href="#">FAQ</a>
				
				<a href="#">Contact</a>
			</p>

			<p class="footer-company-name" style="margin-top:20px">&copy; 2019 FDM VOYAGE all rights reserved</p>			
			
		</div>

		<div class="footer-right">

			<p>Contact Us</p>

			<form action="feedback" method="post">

				<input type="text" name="email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/>
				<textarea name="message" placeholder="Message"></textarea>
				<button>Send</button>

			</form>

		</div>

		</footer>
</html>