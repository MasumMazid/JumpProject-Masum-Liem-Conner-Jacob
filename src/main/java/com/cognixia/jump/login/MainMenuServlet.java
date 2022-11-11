package com.cognixia.jump.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainMenuServlet
 */
public class MainMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String username = request.getAttribute("username").toString();
		//System.out.println(username);
		
		if(request.getParameter("updateProgress") != null) {
			//request.setAttribute("username", username);
			//request.getRequestDispatcher("UpdateProgress").forward(request, response);
			response.sendRedirect("UpdateProgressServlet");
		} else if(request.getParameter("viewProgress") != null) {
			//request.setAttribute("username", username);
			//request.getRequestDispatcher("UpdateProgress").forward(request, response);
			response.sendRedirect("ViewProgressServlet");
		}
		
	}

}
