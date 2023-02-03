package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.TutorialDao;

/**
 * Servlet implementation class DeleteTutorialServlet
 */
@WebServlet("/DeleteTutorial")
public class DeleteTutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteTutorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id=Integer.parseInt(request.getParameter("id"));
	    TutorialDao dao =new TutorialDao(DBConnect.getConn());
		 boolean f=dao.deleteTutorial(id);
	        if(f) {
				response.sendRedirect("index.jsp");
				System.out.println("delete Sucessfully...");
				
			}else {
				response.sendRedirect("index.jsp");
				System.out.println("Fail!");
			}
	}

}
