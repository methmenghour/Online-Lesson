<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
<%@include file="bootstrap_url.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container">
	<div class="row">	     
		<div class="col">
		    <form action="AddTutorialServlet" method="GET">
			  <div class="mb-3">
			    <label for="title" class="form-label">Title</label>
			    <input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp" required>
			  </div>
			  <div class="mb-3">
				  <label for="description" class="form-label">Description</label>
				  <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
			  </div>
			    <div class="mb-3">
				  <label for="example" class="form-label">Example</label>
				  <textarea class="form-control" id="example" name="example" rows="3" required></textarea>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>		
		</div>
	</div>
</div>
</body>
</html>