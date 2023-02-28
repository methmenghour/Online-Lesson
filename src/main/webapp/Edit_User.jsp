<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.UserDao"%>
<%@ page import="java.util.List" %>
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
		  <%
		    int id=Integer.parseInt(request.getParameter("id"));
			UserDao dao=new UserDao(DBConnect.getConn());
			User t=dao.getUserById(id);
		    %>
		    <form action="UpdateUser" method="POST">
			  <div class="mb-3">
			    <label for="username" class="form-label">User Name</label>
			    <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp"  value="<%=t.getUserName()%>">
			  </div>
			  <div class="mb-3">
				  <label for="password" class="form-label">Password</label>
				   <input type="text" class="form-control" id="password" name="password" aria-describedby="emailHelp"  value="<%=t.getPassword()%>">				  
			  </div>
			  <input type="hidden"  name="id" value="<%=t.getId()%>">
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>		
		</div>
	</div>
</div>
</body>
</html>