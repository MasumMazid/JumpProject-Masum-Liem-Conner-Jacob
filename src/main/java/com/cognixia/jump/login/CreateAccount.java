package com.cognixia.jump.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.UserDAO;
import daos.UserDAOClass;
import servlets.MainMenu;
import models.User;
import exceptions.DuplicateUserException;

public class CreateAccount extends HttpServlet {

	private static final long serialVersionUID = -1553054370076316817L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		String username = req.getParameter("username").trim().toLowerCase();
		String password = req.getParameter("pw").trim();
		String passwordVerfied = req.getParameter("pw-verification").trim();
		String name = req.getParameter("full-name").trim();
		
		PrintWriter pw = res.getWriter();
		UserDAO userDao = new UserDAOClass();
		MainMenu mainMenu = new MainMenu(pw);
		
		res.setContentType("text/html");
		try {
			if(password.equals(passwordVerfied)) {
				if(userDao.getUserByUsername(username) == null) {
					userDao.addUser(new User(userDao.getAllUsers().size()+1, name, password, username));
					mainMenu.loadMainMenu(username);
				} else throw new DuplicateUserException("User already exists.");
			}
		} catch(DuplicateUserException e) {
			res.sendRedirect("CreateAccount.jsp");
		}
	}

	
}
