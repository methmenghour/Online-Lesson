<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.entity.Tutorial"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.TutorialDao"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Tutorial</title>
<%@include file="bootstrap_url.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">


    <h3>User Name: ${username} </h3>
    <h3>Password: ${password} </h3>
    <h3>Id: ${id} </h3>



    <div class="row">
    			  <%
			  TutorialDao daoCard=new TutorialDao(DBConnect.getConn());
			  List<Tutorial> listCard=daoCard.getAllTutorial();
			  for(Tutorial t:listCard){	
			  %>
			 <div class="col-3 mt-2">
                <div class="card" style="width: 18rem;">
				  <div class="card-body">
				    <h5 class="card-title"><%=t.getTitle() %></h5>
				    <p class="card-text"><%=t.getDecription()%></p>
                     <a href="View_Tutorial.jsp?id=<%=t.getId()%>" class="btn btn-primary">Go Somewhere</a>
				  </div>
				</div>                 
             </div> 
               
			   <%} 
			  
			   %>          
    </div>
</div>
</body>
</html> 