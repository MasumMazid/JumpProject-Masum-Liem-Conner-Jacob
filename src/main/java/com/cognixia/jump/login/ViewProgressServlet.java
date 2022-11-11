package com.cognixia.jump.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import daos.UserDAOClass;
import daos.UserDAO;
import daos.TvShowDAO;
import daos.TvShowDAOClass;
import models.TvShow;

public class ViewProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString().trim().toLowerCase();
		System.out.println(username);
		
		UserDAO userDao = new UserDAOClass();
		TvShowDAO tvShowDao = new TvShowDAOClass();
		User user = userDao.getUserByUsername(username);
		int totalTvShows = tvShowDao.getAllTvShows().size();
		
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
		pw.println("<center><table><tbody>");
		pw.println("<tr><td>Completed: " + userDao.getNumCompleted(user) + " out of " + totalTvShows + " - " 
		+ userDao.getShowsCompleted(user.getUserId()).toString());
		pw.println("</br></br>");
		pw.println("<tr><td>In Progress: " + userDao.getNumInProgress(user) + " out of " + totalTvShows + " - " 
		+ userDao.getShowsInProgress(user.getUserId()).toString());
		pw.println("</br></br>");
		pw.println("<tr><td>Not Completed: " + userDao.getNumNotCompleted(user) + " out of " + totalTvShows + " - " 
		+ userDao.getShowsNotCompleted(user.getUserId()).toString());
		pw.println("</tbody></table></center>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
