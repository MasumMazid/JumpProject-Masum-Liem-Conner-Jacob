package servlets;

import java.io.PrintWriter;

public class MainMenu {
	private PrintWriter pw;
	
	public MainMenu(PrintWriter pw) {
		this.pw = pw;
	}
	
	public void loadMainMenu(String username) {
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
		pw.println("<form method=\"get\" action=\"MainMenuServlet\">");
		pw.println("<center>");
		pw.println("</br>");
		pw.println("<center><input type=\"submit\" name=\"updateProgress\" value=\"Update Progress\"/></center>");
		pw.println("</br>");
		pw.println("<center><input type=\"submit\" name=\"viewProgress\" value=\"View Progress\"/></center>");
		pw.println("</center>");
		pw.println("</form>");
		pw.println("</br>");
		pw.println("</body>");
		pw.println("</html>");
		
		
	}
}
