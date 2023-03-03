<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.entity.Tutorial"%>
<%@page import="com.dao.TutorialDao"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<%@include file="bootstrap_url.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container">
	<div class="row mt-5">	     
		<div class="col">
		    <%
		    int id=Integer.parseInt(request.getParameter("id"));
			TutorialDao dao=new TutorialDao(DBConnect.getConn());
			Tutorial t=dao.getTuturialById(id);
		    %>
		    <form action="UpdateTutorial" method="POST">
			  <div class="mb-3">
			    <label for="title" class="form-label">Title</label>
			    <input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp"  value="<%=t.getTitle()%>">
			  </div>
			  <div class="mb-3">
				  <label for="description" class="form-label">Description</label>
				  <input type="text" style="height:100px" class="form-control" id="description" name="description" rows="3" value="<%=t.getDecription()%>"></textarea>
			  </div>
			    <div class="mb-3">
				  <label for="example" class="form-label">Example</label>
				  <input type="text" style="height:150px" class="form-control" id="example" name="example" rows="3" value="<%=t.getExample()%>"></textarea>
			  </div>
             <a href="index.jsp" class="btn btn-primary">Back</a>
			</form>		
		</div>
	</div>
</div>
</body>
</html>