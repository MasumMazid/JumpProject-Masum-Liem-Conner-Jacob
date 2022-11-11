package com.cognixia.jump.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.*;
import daos.UserDao;
import servlets.MainMenu;
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
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		User user;
		
		try {
			user = userDao.getUserByUsername(username);
			if((user != null) && (user.getUser_name().equals(username)) 
					&& (user.getUser_password().equals(password))) {
			
				MainMenu mainMenu = new MainMenu(pw);
				mainMenu.loadMainMenu(username);
			} else throw new InvalidUserException("User not found.");
		} catch(InvalidUserException e) {
			res.sendRedirect("IncorrectLogin.jsp");
		}
		
	}

	
}
