<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.ico">
		<meta charset="UTF-8">
		<title>Bates Motel</title>
		<style>
			body {
    			background-repeat: no-repeat;
 				background-color: #cccccc;
 				background-size: cover;
 				background-attachment:fixed;
 				color: #000080;
			}
			ul {
				font-size: 25px;
    			list-style-type: none;
    			border: 1px solid #555;
			}

			li a {
    			display: block;
    			color: #000;
    			padding: 8px 16px;
    			text-decoration: none;
    			color: #000080;
			}

			li {
    			text-align: left;
			    border-bottom: 1px solid #555;
			}

			li:last-child {
			    border-bottom: none;
			}
    			padding: 0;

			li a.active {
    			background-color: #000080;
    			color: white;
			}

			li a:hover:not(.active) {
			    background-color: #555;
			    color: white;
			}
			div.attraction {
				Opacity: 0.8;
				background-color: white;
				width:50%;
				height: 1300px; 
				margin-left: 200px;
			}
			div.cont {
				Opacity: 100;
			}
		}
		</style�
	</head>
	<body background="images/backgroundteste.png">
		<div class="container">
			<div class="menu" style="float:right; margin-top:50px;margin-right:60px;">
				<ul>
					<li><a href="/bates/rooms">Rooms & Roltes</a></li>
					<li><a href="/bates/directions">Directions</a></li>
					<li><a href="/bates/login">Reservations & Bookings</a></li>
					<li><a href="/bates/photos">Photos</a></li>
					<li><a href="/bates/about">About</a></li>
					<li><a href="/bates/contact">Contact Us</a></li>
				</ul>
			</div>
		</div><br><br><br><br><br><br><br>
		<div class = "attraction">
			<div style="background-color: blue;">
				<h1 style="color: white;">Attractions</h1>
			</div>
			<div class = "cont">
				<h2>Museus à beça</h2>
				<img src="images/attraction1.JPG" style="margin-left: 10px;width:50%;">
			</div>
			<div class = "cont">
				<h2>Lagos tambem</h2>
				<img src="images/attraction2.jpg" style="margin-left: 10px;">
			</div>
		</div>
	</body>
</html>