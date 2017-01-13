<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<div id="breadcrumbs">
		<div class="container">
			<ul>
				<li><a href="home">Home</a></li>
				<li>All Products</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	<div id="body">
		<div class="container">
			
			<div class="products-wrap">
				<aside id="sidebar">
				<div class="widget">
					<h3>Products per page:</h3>
					<fieldset>
						<input checked type="checkbox"> <label>8</label> <input
							type="checkbox"> <label>16</label> <input type="checkbox">
						<label>32</label>
					</fieldset>
				</div>
				<div class="widget">
					<h3>Sort by:</h3>
					<fieldset>
						<input checked type="checkbox"> <label>Popularity</label>
						<input type="checkbox"> <label>Date</label> <input
							type="checkbox"> <label>Price</label>
					</fieldset>
				</div>
				<div class="widget" >
					<h3>Condition:</h3>
					<fieldset>
						<input checked type="checkbox"> <label>New</label> <input
							type="checkbox"> <label>Used</label>
					</fieldset>
				</div>
				<div class="widget">
					<h3>Price range:</h3>
					<fieldset>
						<div id="price-range"></div>
					</fieldset>
				</div>
				</aside>
				<div id="content" id="someWid">
					<section class="my-products" id="someWid">
					
					<article id="someWid">
					<img src="${commodity.imagePath}" class="prodImg" alt="">
					
					<h4>
						${commodity.price}
					</h4>
					
					${commodity.description} 
					
					</article> 
					
					</section>
				</div>
				<!-- / content -->
			</div>
			<div class="pagination">
				<ul>
					<li><a href="#"><span class="ico-prev"></span></a></li>
					<li><a href="#">1</a></li>
					<li class="active"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#"><span class="ico-next"></span></a></li>
				</ul>
			</div>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	
</body>
</html>