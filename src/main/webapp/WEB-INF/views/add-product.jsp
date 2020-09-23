<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC 5 - form handling | Java Guides</title>
 
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Spring MVC 5 + Hibernate 5 + JSP + MySQL
    Example</h2>
    <input type="button" value="showall Products"
				onclick="window.location.href='showAllProducts'; return false;"
				class="btn btn-primary" /> <br>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add Product</div>
    </div>
    <div class="panel-body">
     <form:form action="addproduct" cssClass="form-horizontal"
      method="post" modelAttribute="product" enctype="multipart/form-data">

      <!-- need to associate this data with customer id -->
      <form:hidden path="id" />

      <div class="form-group">
       <label for="name" class="col-md-3 control-label">enter the product
        Name</label>
       <div class="col-md-9">
        <form:input path="name" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="brand" class="col-md-3 control-label">enter the brand
        Name</label>
       <div class="col-md-9">
        <form:input path="brand" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <label for="price" class="col-md-3 control-label">enter the price</label>
       <div class="col-md-9">
        <form:input path="price" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="stock" class="col-md-3 control-label">enter the stock</label>
       <div class="col-md-9">
        <form:input path="stock" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="imagePath" class="col-md-3 control-label">Select image</label>
       <div class="col-md-9">
       <form:input path="file" type="file"  name="file" />
       </div>
      </div>

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>