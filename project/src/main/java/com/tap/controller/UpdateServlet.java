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

@WebServlet("/updateprofile")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		User user = (User) session.getAttribute("loggedInUser");
		int userid=user.getUserid();
		System.out.println(userid);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String phonenumber=req.getParameter("phonenumber");
		
		User u1=new User();
		u1.setUsername(username);
		u1.setPassword(password);
		u1.setAddress(address);
		u1.setPhonenumber(phonenumber);
		
		UserDAO uDAO=new UserDAOImpl();
		if(uDAO.updateUserByUid(u1, userid)==1)
		{
			resp.sendRedirect("successupdateprofile.jsp");
		}
		else
		{
			resp.sendRedirect("failedupdateprofile.jsp");
			
		}
	}

}
