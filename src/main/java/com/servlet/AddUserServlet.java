package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.TutorialDao;
import com.dao.UserDao;
import com.entity.Tutorial;
import com.entity.User;


@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		User user =new User(username,password);	
		UserDao dao =new UserDao(DBConnect.getConn());
		
		System.out.println("user"+user.toString());

		boolean f=dao.addUser(user);
		if(f) {
			response.sendRedirect("ListUser.jsp");
			System.out.println(" Add Sucessfully...");
			
		}else {
			response.sendRedirect("Add_User.jsp");
			System.out.println("Fail!");
		}
	}



}
