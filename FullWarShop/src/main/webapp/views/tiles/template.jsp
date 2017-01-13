<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>SolomonoWoods</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" media="all" href="css/style.css">

</head>

<body>




	<header id="header">
	<div class="container">
		<a href="home" id="logo"
			title="Solomono WOOD"><img src="images/solo_logo.PNG" alt=""></a>
		<div class="right-links">
			<ul>

				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="cart"><span class="ico-products"></span>To Cart
							</a></li>
				</sec:authorize>

				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="admin">admin page</a></li>
				</sec:authorize>

				<sec:authorize access="!isAuthenticated()">

					<li><a href="loginpage"><span class="ico-account"></span>Login</a></li>

					<li><a href="registration"><span class="ico-signout"></span>Registration</a></li>

				</sec:authorize>
				<sec:authorize access="isAuthenticated()">

					<!-- <li><a href="logout"><span class="ico-signout"></span>Logout</a></li> -->
					<li><form:form class="ico-signout" action="logout"
							method="post">
							<button class="my-btn">logout</button>
						</form:form></li>
				</sec:authorize>

			</ul>
		</div>
	</div>
	</header>
	<!-- / container -->
	
	<nav id="menu">
	<div class="container">
		<div class="trigger"></div>
		<ul>
			<li><a href="products">All Products</a></li>
			<li><a href="wood">Wood</a></li>
			<li><a href="paper">Paper</a></li>
			<li><a href="toys">Toys</a></li>
			<li><a href="gifts">Gifts</a></li>
			<li><a href="other">Others</a></li>
		</ul>
	</div>
	<!-- / container --> </nav>
	<!-- / navigation -->

	
	<div>
		<tiles:insertAttribute name="body" />
	</div>
	
	<footer id="footer">
	<div class="container">
		<div class="cols">
			<div class="col">
				<h3>Frequently Asked Questions</h3>
				<ul>
					<li><a href="#">Fusce eget dolor adipiscing </a></li>
					<li><a href="#">Posuere nisl eu venenatis gravida</a></li>
					<li><a href="#">Morbi dictum ligula mattis</a></li>
					<li><a href="#">Etiam diam vel dolor luctus dapibus</a></li>
					<li><a href="#">Vestibulum ultrices magna </a></li>
				</ul>
			</div>
			<div class="col media">
				<h3>Social media</h3>
				<ul class="social">
					<li><a href="https://www.facebook.com"><span class="ico ico-fb"></span>Facebook</a></li>
					<li><a href="https://twitter.com"><span class="ico ico-tw"></span>Twitter</a></li>
					<li><a href="https://www.google.com.ua"><span class="ico ico-gp"></span>Google+</a></li>
					<li><a href="https://ru.pinterest.com/"><span class="ico ico-pi"></span>Pinterest</a></li>
				</ul>
			</div>
			<div class="col contact">
				<h3>Contact us</h3>
				<p>
					Diana’s Jewelry INC.<br>54233 Avenue Street<br>New York
				</p>
				<p>
					<span class="ico ico-em"></span>contact@dianasjewelry.com
				</p>
				<p>
					<span class="ico ico-ph"></span>(590) 423 446 924
				</p>
			</div>
			<div class="col newsletter">
				<h3>Join our newsletter</h3>
				<p>Sed ut perspiciatis unde omnis iste natus sit voluptatem
					accusantium doloremque laudantium.</p>
				<%-- <form action="#">
					<input type="text" placeholder="Your email address...">
					<button type="submit"></button>
				</form> --%>
			</div>
		</div>
		<p class="copy">Copyright 2013 Jewelry. All rights reserved.</p>
	</div>
	<!-- / container --> </footer>
	<!-- / footer -->


	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write("<script src='js/jquery-1.11.1.min.js'>\x3C/script>")
	</script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
</body>
</html>