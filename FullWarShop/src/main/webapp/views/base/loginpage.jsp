<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="breadcrumbs">
		<div class="container">
			<ul>
				<li><a href="http://localhost:8080/FullWarShop/">Home</a></li>
				<li>Login Page</li>
			</ul>
		</div>
	</div>

<div class="testbox">
<h2>login</h2>
<hr>
<form:form action="loginprocesing" method="post">
    <input class="reg" name="username" type="text" placeholder="login"/>
    <input class="reg" name="password" type="password" placeholder="password"/>
    <br>
    <br>
    <button class="my-btn">login</button>
    <hr>
</form:form>
</div>

