package com.cognixia.jump.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.UserDao;
import models.User;
import exceptions.InvalidUserException;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1553054370076316817L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		
		String username = req.getParameter("username").trim().toLowerCase();
		String password = req.getParameter("pw").trim();
		res.setContentType("text/html");
		User user;
		
		try {
			user = userDao.getUserByUsername(username);
			if((user != null) && (user.getUser_name().equals(username)) 
					&& (user.getUser_password().equals(password))) {
			
				res.sendRedirect("MainMenuServlet?username=" + username);
			} else throw new InvalidUserException("User not found.");
		} catch(InvalidUserException e) {
			res.sendRedirect("IncorrectLogin.jsp");
		}
		
	}
}
