package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.tvDao;
import java.util.List;

public class UpdateProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString().trim().toLowerCase();
		
		tvDao tvDao = new tvDao();
		
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
		pw.println("<center><h1>Update Progress</h1></center>");
		pw.println("</br>");
		pw.println("<h2><center>Please fill in the form!</center></h2>");
		pw.println("</br>");
		pw.println("<center><table><tbody>");
		List<String> showsWithId;
		try {
			showsWithId = tvDao.getShowsWithId();
			for (String show : showsWithId) 
				pw.println("<tr><td>" + show + "</td></tr>");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		pw.println("");
		pw.println("</tbody></table></center>");
		pw.println("</br>");
		pw.println("<form method=\"get\" action=\"NewProgressServlet?username="+username+"\">");
		pw.println("<input type=\"hidden\" name=\"username\" value=\""+username+"\"/>");
		pw.println("<center><table><tbody>");
		pw.println("<tr><td>Movie ID</td>");
		pw.println("<td><input type=\"text\" name=\"movie-name\"/></td></tr>");
		pw.println("<tr><td>New Progress (0-100)</td>");
		pw.println("<td><input type=\"text\" name=\"new-progress\"/></td></tr>");
		pw.println("</tbody></table></center>");
		pw.println("</br><center><input type=\"submit\" value=\"Submit\"/></center>");
		pw.println("</center></form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
