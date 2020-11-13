
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Category</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">

</head>
<body>
<form:form method="POST" action="/categories/createcategory" modelAttribute="newcategory">
	<div class="form form-group">
	<form:label path="value">Category Name:
	<form:errors path="value"/>
	<form:input path="value"/></form:label>
	</div>
	

	<input type="submit" value="Create Category"/>
	
</form:form>

</body>
</html>