package com.tap.controller;

import java.io.IOException;
import com.tap.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dto.User;


@WebServlet("/register")
public class UserRegister extends HttpServlet {
	
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email=req.getParameter("email");
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String address=req.getParameter("address");
			String phonenumber=req.getParameter("phonenumber");
			User u=new User(email,username,address,password,phonenumber);

			UserDAO userdao=new UserDAOImpl();
			int i=userdao.addUser(u);
			
			if(i!=0) {
				resp.sendRedirect("success.jsp");
			}
			else {
				resp.sendRedirect("failure.jsp");
			}
		}
	
}
