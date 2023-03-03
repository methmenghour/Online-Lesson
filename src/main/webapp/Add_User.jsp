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
	<div class="row mt-4">
	    <div class="col"></div>
		<div class="col">
		    <form action="AddUserServlet" method="GET">
			  <div class="mb-3">
			    <label for="username" class="form-label">User Name</label>
			    <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp" required>
			  </div>
			  <div class="mb-3">
				  <label for="password" class="form-label">Password</label>
				   <input type="password" class="form-control" id="password" name="password" aria-describedby="emailHelp" required>				  
			  </div>
			  <button type="submit" class="btn btn-primary">Register</button>
			</form>		
		</div>
	   <div class="col"></div>		
	</div>
</div>
</body>
</html>