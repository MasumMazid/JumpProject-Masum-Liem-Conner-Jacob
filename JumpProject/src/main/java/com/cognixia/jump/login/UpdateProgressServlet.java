package com.cognixia.jump.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.tvDao;
import daos.UserDao;
import models.User;

/**
 * Servlet implementation class UpdateProgressServlet
 */
public class UpdateProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString().trim().toLowerCase();
		
		UserDao userDao = new UserDao();
		tvDao tvShowDao = new tvDao();
		User user = userDao.getUserByUsername(username);
		int totalTvShows = 0;
		try {
			totalTvShows = tvShowDao.getShows().size();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Main Menu</title>");
		pw.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
		pw.println("</head>");	
		pw.println("<body>");
		pw.println("<div style=\"border: thin solid black; padding:5px;\" value=\""+username
				+"\" name=\"username\">Username: " + username 
				+ "\t<a href=\"index.jsp\">Sign Out</a></div>");
		pw.println("</br>");
		pw.println("<center><h1>Progress Report</h1></center>");
		pw.println("</br></br>");
		
		pw.println("<form method=\"get\" action=\"UpdateProgress?username="+username+"\"/><center>");
		pw.println("<table><tbody>");
		
		pw.println("</tbody></table>");
		pw.println("</center></form>");
		
		pw.println("</body>");
		pw.println("</html>");
	}
}
