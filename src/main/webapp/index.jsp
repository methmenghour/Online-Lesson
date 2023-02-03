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
<title>List Tutorial</title>
<%@include file="bootstrap_url.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<%-- <%
Connection conn=DBConnect.getConn();
out.print(conn);
%> --%>

<div class="container">
    <div class="row mt-5">
         <div class="col d-flex justify-content-end">
              <button type="button" class="btn btn-primary"><a class="nav-link" href="Add_Tutorial.jsp">Add</a>
              </button>
             
         </div>
     </div>
    <div class="row">
         <div class="col">
           <div class="table-responsive">           
		    <table class="table table-striped table-hover">
			  <thead>
			    <tr>
			      <th>#</th>
			      <th>Title</th>
			      <th>Description</th>
			      <th>Example</th>
			      <th colspan="2">Action</th>			      
			    </tr>
			  </thead>
			  <tbody>
			  <%
			  TutorialDao dao=new TutorialDao(DBConnect.getConn());
			  List<Tutorial> list=dao.getAllTutorial();
			  int i=0;
			  for(Tutorial t:list){	
				  i++;
			  %>
			    <tr>
			      <th><%=i %></th>
			      <th><%=t.getTitle() %></th>	
			      <th><%=t.getDecription() %></th>
			      <th><%=t.getExample() %></th>	      
			    <%--   <td>
			      <a href="Edit_Tutorial.jsp?id=<%=t.getId()%>" class="btn btn-sm btn-primary"><i class="bi bi-pencil"></i></a>
			       <a class="btn btn-sm btn-danger"><i class="bi bi-trash"></i></a>	      
			      </td>	 --%>
			       <td>
			      <a href="Edit_Tutorial.jsp?id=<%=t.getId()%>" class="btn btn-sm btn-primary"><i class="bi bi-pencil"></i></a>
			      </td>	 
			       <td>
			       <a class="btn btn-sm btn-danger" href="DeleteTutorial?id=<%=t.getId()%>"><i class="bi bi-trash"></i></a>	      
			      </td>	       
			    </tr>
			   <%} 
			   %>
			  </tbody>
			</table>
			</div>
        </div>
    </div>
</div>
</body>
</html> 