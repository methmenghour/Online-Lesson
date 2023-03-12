package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.UserDao;
import com.entity.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
      
			User user =new User(username,password);	
		
			UserDao dao =new UserDao(DBConnect.getConn());
			User getUser=dao.getUserLogin(user);
	       
			if(getUser!=null) {
				/*
				 * System.out.println("Name"+getUser.getUserName());
				 * response.sendRedirect("index.jsp");
				 */
		
				request.setAttribute("username",getUser.getUserName());
				request.setAttribute("password",getUser.getPassword());
				request.setAttribute("id",getUser.getId()); 
				
				HttpSession session=request.getSession();
				session.setAttribute("username", getUser.getUserName());
				session.setAttribute("password", getUser.getPassword());

				request.getRequestDispatcher("index.jsp").forward(request, response);

			}else {
				request.setAttribute("error"," Login Fail");
				//response.sendRedirect("Login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);


			}

	}

}
