<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
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

<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>display all the products here123!!!!!!!!!!!</h2>
			<hr />





			
			<br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Product List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Brand </th>
							<th>price</th>
							<th>stock</th>
							<th>image</th>
							<th>image</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="tempProduct" items="${products}">

							<!-- construct an "update" link with customer id -->
							<%-- <c:url var="updateLink" value="/customer/updateForm">
								<c:param name="customerId" value="${tempCustomer.id}" />
							</c:url> --%>

							<!-- construct an "delete" link with customer id -->
							<%-- <c:url var="deleteLink" value="/customer/delete">
								<c:param name="customerId" value="${tempCustomer.id}" />
							</c:url> --%>

							<tr>
								<td>${tempProduct.id}</td>
								<td>${tempProduct.name}</td>
								<td>${tempProduct.brand}</td>
								<td>${tempProduct.price}</td>
								<td>${tempProduct.stock}</td>
								<%-- <td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td> --%>
								<td>${tempProduct.img_path}</td>
								<td>
								<img width="30%" height="30%" alt="product_pic" src="<spring:url value='/resources/images/${tempProduct.img_path}' />">
								</td>

							</tr>

						</c:forEach>

					</table>




				</div>
			</div>
		</div>

	</div>
<div class="container" style="background-color:pink;">
<div class="row">
  <c:forEach var="tempProduct" items="${products}">
  <div class="column col-lg-6">
 <img alt="product_pic" src="<spring:url value='/resources/images/${tempProduct.img_path}' />"> 
							<%-- 	<p>${tempProduct.id}<p> --%>
								<h2>Product name : ${tempProduct.name}</h2>
						
						<h3>Brand Name: <span class="highlight">${tempProduct.brand}</span></h3>
								<h4>Price: ${tempProduct.price}</h4>
								<h4> Stock: ${tempProduct.stock}</h4>
    
  </div>
  </c:forEach>
</div>
</div>
<style>
img{
display: inline-block;
width: 50%;
height: 20%;
}
</style>
</body>
</html>