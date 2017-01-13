<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <div id="slider">
		<ul>
			<li style="background-image: url(images/sl1.jpg)">
				<h3>Make your life better</h3>
				<h2>Genuine Wood Producrs</h2> 
			</li>
			<li class="purple" style="background-image: url(images/sl2.jpg)">
				<h3>You will say “yes”</h3>
				<h2>Best Wood Ever</h2> 
			</li>
			<li class="yellow" style="background-image: url(images/sl3.jpg)">
				<h3>You deserve to be Creative</h3>
				<h2>Wooden Accesorise</h2> 
			</li>
		</ul>
	</div>
    
    <div id="body">
		<div class="container">
			<div class="last-products">
				<h2>Last added products</h2>
				<section class="products"> 
				
				
				<c:forEach var="commodity" items="${commoditys}">
					<article>
					<a href="product.html"><img src="${commodity.imagePath}" class="prodImg" alt=""></a>
					<h3>
						<a href="product.html">${commodity.name}</a>
					</h3>
					<h4>
						<a href="product.html">${commodity.price}</a>
					</h4>
					<sec:authorize access="hasRole('ROLE_USER')">
					<a href="buycommodity/${commodity.id}" class="btn-add">Add to cart</a> 
					</sec:authorize>
					</article> 
					</c:forEach>
				
				
				
				
				
				
				
				
				<!-- <article> -->
				<!-- <img src="images/11.jpg" alt="">
				<h3>Lorem ipsum dolor</h3>
				<h4>$990.00</h4>
				<a href="cart.html" class="btn-add">Add to cart</a> </article> 
				<article>
				<img src="images/12.jpg" alt="">
				<h3>cupidatat non proident</h3>
				<h4>$1 200.00</h4>
				<a href="cart.html" class="btn-add">Add to cart</a> </article> <article>
				<img src="images/13.jpg" alt="">
				<h3>Duis aute irure</h3>
				<h4>$2 650.00</h4>
				<a href="cart.html" class="btn-add">Add to cart</a> </article> <article>
				<img src="images/14.jpg" alt="">
				<h3>magna aliqua</h3>
				<h4>$3 500.00</h4>
				<a href="cart.html" class="btn-add">Add to cart</a> </article>  -->
				</section>
			</div>
			<section class="quick-links"> <article
				style="background-image: url(images/2.jpg)"> 
				<div class="cell">
					<div class="text">
						<h4>Lorem ipsum</h4>
						<hr>
						<h3>Dolor sit amet</h3>
					</div>
				</div>
			 </article> <article class="red" style="background-image: url(images/3.jpg)">
			
				<div class="cell">
					<div class="text">
						<h4>consequatur</h4>
						<hr>
						<h3>voluptatem</h3>
						<hr>
						<p>Accusantium</p>
					</div>
				</div>
			 </article> <article style="background-image: url(images/4.jpg)">
				<div class="cell">
					<div class="text">
						<h4>culpa qui officia</h4>
						<hr>
						<h3>magnam aliquam</h3>
					</div>
				</div>
			 </article> </section>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	