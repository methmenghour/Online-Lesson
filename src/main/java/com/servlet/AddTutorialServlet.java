package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.TutorialDao;
import com.entity.Tutorial;
import com.mysql.cj.Session;

/**
 * Servlet implementation class AddTutorialServlet
 */
@WebServlet("/AddTutorialServlet")
public class AddTutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTutorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * // TODO Auto-generated method stub String
		 * title=request.getParameter("title"); String
		 * description=request.getParameter("description");
		 * response.getWriter().append("Served at: "+title);
		 * //response.getWriter().append("Served at: ").append(request.getContextPath());
		 * 
		 * 	response.getWriter().append("Served at: "+title+" "+description+" "+example); 
		 */	
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String example=request.getParameter("example");
		Tutorial tutorial =new Tutorial(title,description,example);	
		TutorialDao dao =new TutorialDao(DBConnect.getConn());
		boolean f=dao.addTutorial(tutorial);
		if(f) {
			response.sendRedirect("index.jsp");
			System.out.println(" Add Sucessfully...");
			
		}else {
			response.sendRedirect("Add_Tutorial.jsp");
			System.out.println("Fail!");
		}
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String example=request.getParameter("example");
		Tutorial tutorial =new Tutorial(title,description,example);
		System.out.println(tutorial);

	}
   */
}
