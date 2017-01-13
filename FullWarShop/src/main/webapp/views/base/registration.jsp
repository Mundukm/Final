<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="breadcrumbs">
	<div class="container">
		<ul>
			<li><a href="http://localhost:8080/FullWarShop/">Home</a></li>
			<li>Registration Page</li>
		</ul>
	</div>
</div>

<div class="testbox">
	<h1>Registration</h1>



	<form:form modelAttribute="newUser" action="addUser" method="get">
		<hr>

	<div style="text-align: center; color: red; margin: 5px">
			<label for="email">${usernameException}</label>
		</div>
		

		<label id="icon" for="name"><i class="fa fa-university"
			aria-hidden="true"></i></label>
		<form:input class="reg" path="name" type="text" name="name" id="name"
			placeholder="name" />
		<br>



		<label id="icon" for="name"><i class="icon-user"></i></label>
		<form:input class="reg" path="Surname" type="text" name="name"
			id="name" placeholder="surname" />
		<br>

		<div style="text-align: center; color: red; margin: 5px">
			<label for="email">${emailException}</label>
		</div>

		<label id="icon" for="name"><i class="icon-envelope"></i></label>
		<form:input class="reg" path="email" type="text" name="name" id="name"
			placeholder="email" />
		<br>

		<div style="text-align: center; color: red; margin: 5px">
			<label for="phone">${phoneException}</label>
		</div>

		<label id="icon" for="name"><i class="icon-phone"></i></label>
		<form:input class="reg" path="phone" type="text" name="name"
			id="name" placeholder="Telephone Number" />
		<br>

		<div style="text-align: center; color: red; margin: 5px">
			<label for="password">${passwordException}</label>
		</div>

		<label id="icon" for="name"><i class="icon-shield"></i></label>
		<form:input class="reg" path="password" type="password" name="name"
			id="name" placeholder="Password" />
		<br>

		<button class="my-btn">Register</button>
		<hr>
	</form:form>
</div>











