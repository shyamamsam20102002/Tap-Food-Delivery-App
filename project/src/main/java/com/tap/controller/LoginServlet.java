package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.UserDAO;
import com.tap.dao.UserDAOImpl;
import com.tap.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserDAO userdao=new UserDAOImpl();
		User u=userdao.getUser(email);
		//System.out.println("Login 25 : "+u+" password : "+password);
		if(password.equals(u.getPassword()))
		{
			HttpSession session=req.getSession();
			session.setAttribute("loggedInUser",u);
			session.setAttribute("email", u.getEmail());
			resp.sendRedirect("home1");
		}
		else
		{
			resp.sendRedirect("failure.jsp");
		}
	}
}
