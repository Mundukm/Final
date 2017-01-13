<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<h1>Add Commodity</h1>

<div class="right-links">
<c:forEach var="commodity" items="${allCommodity}">
	${commodity.name} ${commodity.price} 
	<a href="deleteCommodity/${commodity.id}">delete</a>

	<br>

</c:forEach>
</div>
<form action="./addCommodity?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<input name="name" placeholder="NAME"/>
	<br>
	<input name="price" placeholder="PRICE"/>
	<br>
	<input name="description" placeholder="DESCRIPTION"/>
	<p>add photo</p>
	<input type="file" name="imagePath">
	<p>select category</p>
	<select class="my-select" name="categoryid">

		<c:forEach var="category" items="${allCategory}">

			<option value="${category.id}">${category.name}</option>

		</c:forEach>

	</select>

	<%-- <select name="materialid">
		<c:forEach var="material" items="${allMaterial}">

			<option value="${material.id}">${material.name}</option>

		</c:forEach>
	</select> --%>

	
	<br>
	<button>save</button>

</form>

<h1>Category</h1>

<c:forEach var="category" items="${allCategory}">

	${category.name}
	<a href="deleteCategory/${category.id}">delete</a>
	<br>

</c:forEach>

<form:form modelAttribute="newCategory" action="addCategory"
	method="post">

	<form:input path="name" />
	<button>save</button>

</form:form>

<h1>Material</h1>

<c:forEach var="material" items="${allMaterial}">

	${material.name}
	<a href="deleteMaterial/${material.id}">delete</a>
	<br>
</c:forEach>

<form:form modelAttribute="newMaterial" action="addMaterial"
	method="post">

	<form:input path="name" />
	<button>save</button>

</form:form>
