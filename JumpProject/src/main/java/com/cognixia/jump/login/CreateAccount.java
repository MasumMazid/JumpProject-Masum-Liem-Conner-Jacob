package com.cognixia.jump.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.UserDao;
import exceptions.DuplicateUserException;

public class CreateAccount extends HttpServlet {

	private static final long serialVersionUID = -1553054370076316817L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		String username = req.getParameter("username").trim().toLowerCase();
		String password = req.getParameter("pw").trim();
		String passwordVerified = req.getParameter("pw-verification").trim();
		UserDao userDao = new UserDao();
		
		res.setContentType("text/html");
		
		try {
			if(password.equals(passwordVerified)) {
				if(userDao.getUserByUsername(username) == null) {
					try {
						userDao.CreateAccount(username, password);
						res.sendRedirect("MainMenuServlet?username=" + username);
					} catch(SQLException e) {
						throw new DuplicateUserException("User already exists.");
					}
				} else {
					throw new DuplicateUserException("User already exists.");
				}
			}
		} catch(DuplicateUserException e) {
			res.sendRedirect("BadCreateAccount.jsp");
		}
	}
}
