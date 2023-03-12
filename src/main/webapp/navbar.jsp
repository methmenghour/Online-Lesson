<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand"href="index.jsp">Tutorial</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
           <% 
         String username = (String)request.getSession().getAttribute("username");
         String password = (String)request.getSession().getAttribute("password");
         %>
        <li class="nav-item">
          <a class="nav-link" href="ListTutorial.jsp">List Tutorial</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ListUser.jsp">List User</a>          
        </li>
         <li class="nav-item">   
           <a class="nav-link" href="#"> <%=username %> AND <%=password%></a>        
        </li>
      </ul>
      
      <form class="d-flex">
          <a href="Add_User.jsp" class="btn btn-primary">Register</a>
          <a href="Login.jsp" class="btn btn-primary">Login</a>              
      </form>
    </div>
  </div>
</nav>