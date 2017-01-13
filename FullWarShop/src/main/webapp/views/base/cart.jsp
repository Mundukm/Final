<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<div id="breadcrumbs">
		<div class="container">
			<ul>
				<li><a href="home">Home</a></li>
				<li>Cart</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	<div id="body">
		<div class="container">
			<div id="content" class="full">
				<div class="cart-table">
					<table>
						<tr>
							<th class="items">Items</th>
							<th class="price">Price</th>
							
							<th class="total">Total</th>
							<th class="delete"></th>
						</tr>
						
						<c:forEach var="commodity" items="${user.commodityList}">
						
						
						
						<tr>
							<td class="items">
								<div class="image">
									<img src="${commodity.imagePath}" class="prodImg" alt="">
								</div>
								<h3><a href="#">${commodity.name}</a></h3>
								<p>${commodity.description}</p>
							</td>
							<td class="price">$ ${commodity.price} </td>
							
							<td class="total">$ ${commodity.price} </td>
							<td class="delete"><a href="deletecommodity/${commodity.id}" class="ico-del"></a></td>
						</tr>
						
						
						
						</c:forEach>
						
						
						
					</table>
				</div>

				<div class="total-count">
					<h4>Number of products: ${numberOfProducts}</h4>
					
					<h3>Total to pay: <strong>$ ${totalPrice}</strong></h3>
					<a href="#" class="btn-grey">Finalize and pay</a>
				</div>
		
			</div>
			<!-- / content -->
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->