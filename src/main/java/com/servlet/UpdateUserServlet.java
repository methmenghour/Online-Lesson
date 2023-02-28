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

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		 int id=Integer.parseInt(request.getParameter("id"));
      
			User user =new User(id,username,password);	
		
		UserDao dao =new UserDao(DBConnect.getConn());
		boolean f=dao.UpdateUser(user);
        if(f) {
			response.sendRedirect("ListUser.jsp");
			System.out.println("Update Sucessfully...");
			
		}else {
			response.sendRedirect("Add_User.jsp");
			System.out.println("Fail!");
		}
	}

}
