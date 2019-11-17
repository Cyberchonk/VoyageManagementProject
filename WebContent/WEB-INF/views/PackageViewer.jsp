<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
   <link rel="stylesheet" href="resources/css/ProjectStyle.css">
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
   
   <div href="javascript:void(0)" class="searchBar">
      <a href="dashboard" class="active">Home</a>
      <a href="customize">Customize</a>
      <a href="package">All Packages</a>
      <a href="bookedpackage">My Packages</a>
      <a href="#about">About</a>
      <a href="logout" id="GuestOptions" style="margin-right: 2%">Logout</a>
	  <a id="GuestOptions" style="width:200px;">Welcome, ${sessionScope.user.getFirstName()} </a>
   </div> 
   
   <!-- Featured Packages -->
   
   <div class="main" style="background-color:white">

   <h2 style="margin-left:10px; margin-top:20px; word-spacing:5px; font-family: Arial, Helvetica, sans-serif;">All Available Packages</h2>
   
   <div class="row">
   
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1001").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1001").toString()))){%>
     <div class="column">
       <a href="packagedetail1001"><div class="content">
         <img src="resources/img/Kyoto4.jpg" style="width:100%">
         <h3>${applicationScope.P1001.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1001.getDeparture_Date()}</p>
         <p>Nagoya is the largest city in the Chubu region of Japan. It is Japan's 4th-largest incorporated city and the third-most-populous urban area. It is located on the Pacific coast on central Honshu </p>
       </div></a>
     </div>
     <%} %>
     
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1002").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1002").toString()))){%>    
     <div class="column">
       <a href="packagedetail1002"><div class="content">
       <img src="resources/img/Kyoto5.jpg" style="width:100%">
         <h3>${applicationScope.P1002.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1002.getDeparture_Date()}</p>
         <p>Sapporo, capital of the mountainous northern Japanese island of Hokkaido, is famous for its beer, skiing and annual Sapporo Snow Festival featuring enormous ice sculptures.</p>
       </div></a>
     </div>
     <%} %>
  
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1003").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1003").toString()))){%>     
     <div class="column">
       <a href="packagedetail1003"><div class="content">
       <img src="resources/img/Kyoto6.PNG" style="width:100%">
         <h3>${applicationScope.P1003.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1003.getDeparture_Date()}</p>
         <p>The Greater Tokyo Area is the most populous metropolitan area in the world. It is the seat of the Emperor of Japan, the Japanese government and the National Diet</p>
       </div></a>
     </div>
     <%} %>
     
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1004").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1004").toString()))){%>
     <div class="column">
       <a href="packagedetail1004"><div class="content">
       <img src="resources/img/Kyoto7.jpg" style="width:100%">
         <h3>${applicationScope.P1004.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1004.getDeparture_Date()}</p>
         <p>Osaka is a large port city and commercial center on the Japanese island of Honshu. It's known for its modern architecture, nightlife and hearty street food.</p>
       </div></a>
     </div>
     <%} %>
   <!-- END GRID -->
   </div>

   <!-- Package Gallery Grid -->
   <div class="row">
   
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1005").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1005").toString()))){%>
     <div class="column">
       <a href="packagedetail1005"><div class="content">
         <img src="resources/img/Kyoto3.jpg" style="width:100%">
         <h3>${applicationScope.P1005.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1005.getDeparture_Date()}</p>
         <p>Yokohama is the second largest city in Japan by population, and the most populous municipality of Japan. It is a major commercial hub of the Greater Tokyo Area as well as a major port city. </p>
       </div></a>
     </div>
     <%} %>
     
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1006").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1006").toString()))){%>
     <div class="column">
       <a href="packagedetail1006"><div class="content">
       <img src="resources/img/Kyoto.PNG" style="width:100%">
         <h3>${applicationScope.P1006.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1006.getDeparture_Date()}</p>
         <p>Mount Fuji, located on Honshu, is the highest volcano in Japan at 3,776.24 m, 2nd-highest peak of an island (volcanic) in Asia, and 7th-highest peak of an island in the world.</p>
       </div></a>
     </div>
     <%} %>
     
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1007").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1007").toString()))){%>
     <div class="column">
       <a href="packagedetail1007"><div class="content">
       <img src="resources/img/Kyoto1.jpg" style="width:100%">
         <h3>${applicationScope.P1007.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1007.getDeparture_Date()}</p>
         <p>Kyoto, once the capital of Japan, is a city on the island of Honshu. It's famous for its numerous Buddhist temples, gardens, imperial palaces, Shinto shrines and traditional wooden houses.</p>
       </div></a>
     </div>
     <%} %>
     
   <% if ((request.getAttribute("cityName") == null && request.getAttribute("departureDate") == null) || 
		  (request.getAttribute("cityName").toString().equals(request.getAttribute("city1008").toString()) && request.getAttribute("departureDate").toString().equals(request.getAttribute("date1008").toString()))){%>
     <div class="column">
       <a href="packagedetail1008"><div class="content">
       <img src="resources/img/Kyoto2.jpg" style="width:100%">
         <h3>${applicationScope.P1008.getCity()} Package</h3>
         <p style="font-family: Arial, Helvetica, sans-serif;">Departing on: ${applicationScope.P1008.getDeparture_Date()}</p>
         <p>Mount Fuji, located on Honshu, is the highest volcano in Japan at 3,776.24 m, 2nd-highest peak of an island (volcanic) in Asia, and 7th-highest peak of an island in the world.</p>
       </div></a>
     </div>
     <%} %>
   <!-- END GRID -->
   </div>

   <!-- END MAIN -->
   </div>

   <footer id="about" class="footer-distributed">

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
   // When the user scrolls the page, execute myFunction 
   window.onscroll = function() {myFunction()};

   // Get the navbar
   var navbar = document.getElementById("searchBar");

   // Get the offset position of the navbar
   var sticky = navbar.offsetTop;

   // Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
   function myFunction() {
     if (window.pageYOffset >= sticky) {
       navbar.classList.add("sticky")
     } else {
       navbar.classList.remove("sticky");
     }
}
   
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