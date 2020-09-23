<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Submitted File</h2>
	<table>
		<tr>
			<td>Product Object:</td>
			<td>${product}</td>
		</tr>
		<tr>
			<td>Product Name:</td>
			<td>${product.name}</td>

			<tr>
			<td>Product Image:</td>
			<td>${product.file}</td>
		</tr>
		<tr>
		<td>Product Image Name:</td>
		<td>${product.file.originalFilename}</td>
		</tr>
		<tr>
		<td>Product Image Name Type123:</td>
			<td>${product.file.contentType}</td>
		</tr>
	
		
	
	</table>
	<p>${msg}</p>
	<p>${f_path}</p>
	<p>Profile Image: 
	<img width="10%" height="10%" alt="hasnain_pic" src="<spring:url value='/resources/images/${product.file.originalFilename}' />"></p>
</body>
</html>