package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.TutorialDao;
import com.entity.Tutorial;

/**
 * Servlet implementation class UpdateTutorialServlet
 */
@WebServlet(name = "UpdateTutorial", urlPatterns = { "/UpdateTutorial" })
public class UpdateTutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTutorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String example=request.getParameter("example");
		 int id=Integer.parseInt(request.getParameter("id"));
         
			System.out.println(id);
			System.out.println(description);
			System.out.println(example);
			System.out.println(title);

		Tutorial tutorial =new Tutorial(id,title,description,example);
		
		TutorialDao dao =new TutorialDao(DBConnect.getConn());
		boolean f=dao.UpdateTutorial(tutorial);
        if(f) {
			response.sendRedirect("ListTutorial.jsp");
			System.out.println("Update Sucessfully...");
			
		}else {
			response.sendRedirect("Add_Tutorial.jsp");
			System.out.println("Fail!");
		}
	}

}
