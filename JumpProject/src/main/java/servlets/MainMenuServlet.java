package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		String username = request.getParameter("username").trim().toLowerCase();
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
				+ "<a href=\"index.jsp\">Sign Out</a></div>");
		pw.println("</br>");
		pw.println("<center><h1>Main Menu</h1></center>");
		pw.println("<form method=\"get\" action=\"UpdateProgressServlet?username="+username+"\">");
		pw.println("<center>");
		pw.println("</br>");
		pw.println("<center><input type=\"hidden\" name=\"username\" value=\""+username+"\"/></center>");
		pw.println("<center><input type=\"submit\" name=\"updateProgress\" value=\"Update Progress\"/></center>");
		pw.println("</center>");
		pw.println("</form>");
		
		pw.println("<form method=\"get\" action=\"ViewProgressServlet?username="+username+"\">");
		pw.println("<center>");
		pw.println("</br>");
		pw.println("<center><input type=\"hidden\" name=\"username\" value=\""+username+"\"/></center>");
		pw.println("<center><input type=\"submit\" name=\"viewProgress\" value=\"View Progress\"/></center>");
		pw.println("</center>");
		pw.println("</form>");
		pw.println("</br>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
