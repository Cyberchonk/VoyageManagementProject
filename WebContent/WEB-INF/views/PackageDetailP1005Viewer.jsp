<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
   <link rel="stylesheet" href="resources/css/PackageViewer.css">
</head>

<body>

   <div class="header">
      <img class = "ImageGallery" src="resources/img/Japan-Fukushima.jpg">
      <a href="dashboard">
	     <img class="logo" src="resources/img/Picture2.png" style="margin-left: 4%; width: 25%">
	  </a>  
	  
	  <form action="search" method="POST">
	  <div class="search">
	  	 <div class="searchOption" style="text-align: center;">
	        <input type="image" src="resources/img/SearchButton.png" alt="Submit" width="20px">
	     </div>
	     <div class="searchOption">
		    <input autocomplete="off" placeholder="Theme" type="hidden" name="theme">
		 </div>
		 <div class="searchOption">
		    <input autocomplete="off" placeholder="Departure Date" type="date" min='2019-05-17' max='2020-06-01' name="departureDate" required>		 
		 </div>
		 <div class="searchOption">
		    <!-- <input autocomplete="off" placeholder="Destination" type="text" name="city" style="height:22px" required> -->
		 <select name="city" autocomplete="off" placeholder="Destination" type="text" style="height:22px" required>
            <option value="Shawn" disabled selected >-- Select City --</option>           
            <option value="Fujiyama">Fujiyama</option>
            <option value="Kyoto">Kyoto</option>
            <option value="Nagoya">Nagoya</option>
            <option value="Sapporo">Sapporo</option>
            <option value="Tokyo">Tokyo</option>
            <option value="Osaka">Osaka</option>
            <option value="Yokohama">Yokohama</option>
         </select>
		 </div>
		 
	  </div>
	  </form>
   </div>

   <!-- Search Bar -->
   
   <div class="searchBar">
      <a href="dashboard" class="active">Home</a>
      <a href="customize">Customize</a>
      <a href="package">All Packages</a>
      <a href="bookedpackage">My Packages</a>
      <a href="#about">About</a>
      <a href="logout" id="GuestOptions" style="margin-right: 2%">Logout</a>
	  <a id="GuestOptions" style="width:200px;">Welcome, ${sessionScope.user.getFirstName()} </a>
   </div> 
   
   <!-- Package Intro -->
   
   <div class="intro-container">
      <p class="intro intro-title">${applicationScope.P1005.getCity()} Tour Package</p>
	  <p class="intro intro-detail">Yokohama is the second largest city in Japan by population, and the most populous municipality of Japan. It is a major commercial hub of the Greater Tokyo Area as well as a major port city.</p>
	  <div class="price">$ ${applicationScope.P1005.getPrice()} / Person</div>
	  
	  <c:set var="count" value="0"/>
  	  <c:forEach items="${sessionScope.user.getpList()}" var="package1">
	  <c:if test="${package1.getPackageID() == 1005}"> 
	  <c:set var="count" value="1"/>
 	  </c:if>
	  </c:forEach> 
	  
	  <c:if test="${count == 0}">
	  <form action="book" method="POST">
	     <input value="1005" name="pID" style="display:none;">
	     <button class="book-button">BOOK NOW</button>
	  </form>
 	  </c:if>
 	  
 	  <c:if test="${count == 1}">
	  <form action="cancel" method="POST">
	     <input value="1005" name="pID" style="display:none;">
	     <button class="book-button">CANCEL</button>
	  </form>
 	  </c:if>
	  
   </div>
   
   <!-- Image Gallery -->
   
   <div class="w3-content w3-display-container" style="height:400px">
     <img class="mySlides" src="resources/img/Yokohama.jpg" style="width:100%">
     <img class="mySlides" src="resources/img/img_2.jpg" style="width:100%">
     <img class="mySlides" src="resources/img/img_3.jpg" style="width:100%">

     <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
     <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
   </div>

   <footer class="footer-distributed">

		<div class="footer-left" style="width:30%">

        <image class="logo-bottom" src="resources/img/Picture2.png" style="margin-left: 2%; width: 100%"> 

			<p class="footer-links">
				<a href="dashboard">Home</a>
				
				<a href="package">Packages</a>
				
				<a href="customize">Customize</a>
				
				<a href="#about">About</a>
				
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
   var slideIndex = 1;
   showDivs(slideIndex);

   function plusDivs(n) {
     showDivs(slideIndex += n);
   }

   function showDivs(n) {
     var i;
     var x = document.getElementsByClassName("mySlides");
     if (n > x.length) {slideIndex = 1}
     if (n < 1) {slideIndex = x.length}
     for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
     }
     x[slideIndex-1].style.display = "block";  
   }

   function openPage(pageName,elmnt,color) {
     var i, tabcontent, tablinks;
     tabcontent = document.getElementsByClassName("tabcontent");
     for (i = 0; i < tabcontent.length; i++) {
       tabcontent[i].style.display = "none";
     }
     tablinks = document.getElementsByClassName("tablink");
     for (i = 0; i < tablinks.length; i++) {
       tablinks[i].style.backgroundColor = "";
     }
     document.getElementById(pageName).style.display = "block";
     elmnt.style.backgroundColor = color;
   }
   
   function myAlertFunction(isBooked){
	   if(isBooked != null && isBooked == true){alert("You have already booked this package !");}
   }

   // Get the element with id="defaultOpen" and click on it
   document.getElementById("defaultOpen").click();
   
   var today = new Date();
   var dd = today.getDate();
   var mm = today.getMonth()+1; //January is 0!
   var yyyy = today.getFullYear();
    if(dd<10){
           dd='0'+dd
       } 
       if(mm<10){
           mm='0'+mm
       } 

   today = yyyy+'-'+mm+'-'+dd;
   document.getElementById("datefield").setAttribute("max", today);
   </script>
   
</body>

</html>