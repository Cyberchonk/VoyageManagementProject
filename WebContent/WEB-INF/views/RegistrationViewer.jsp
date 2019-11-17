<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
   <link rel="stylesheet" href="resources/css/RegistrationViewer.css">
</head>

<body>

   <div class="header">
      <image class = "ImageGallery" src="resources/img/PVFukushima.jpg">
      <a href="home">
	     <image class="logo" src="resources/img/Picture2.png" style="margin-left: 4%; width: 25%">
	  </a>  

   </div>

   
   
   <form action="register" method="POST">
     <div class="container">
       <h1>Register</h1>
       <p>Please fill in this form to create an account.</p>
       <hr>

       <label for="username"><b>Username</b></label>
       <input type="text" placeholder="Enter Username" name="username" required>
	   
	   <label for="firstname"><b>First Name</b></label>
       <input type="text" placeholder="Enter First Name" name="firstname" pattern="[a-zA-Z]{2,12}" required>
	   
	   <label for="lastname"><b>Last Name</b></label>
       <input type="text" placeholder="Enter Last Name" name="lastname" pattern="[a-zA-Z]{2,12}" required>
	   
	   <label for="email"><b>Email Address</b></label>
       <input type="text" placeholder="Enter Email Address" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>

       <label for="psw"><b>Password</b></label>
       <input type="password" id="pwd" placeholder="Enter Password" name="psw" required>

       <label for="psw-repeat"><b>Repeat Password</b></label>
       <input type="password" id="pwd-repeat" placeholder="Repeat Password" name="psw-repeat" onblur="validate()" required>
       <h3 class="error" style="text-align: center; color:red;">${errorMessage}</h3> <!-- EL -->
	   
       <hr>

       <button type="submit" class="registerbtn">Register</button>
     </div>
  
     <div class="container signin">
       <p>Already A Member? <a href="login">Sign In</a>.</p>
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
		
		<script>
		
		function validate() {
			var x= document.getElementById("pwd");
			var y= document.getElementById("pwd-repeat");
			if(x.value == y.value) return;
			else alert("Password doesn't match !");
			}
		
		</script>
		
		</body>
</html>