package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.MenuDAO;
import com.tap.dao.MenuDAOImpl;
import com.tap.dto.Menu;

@WebServlet("/menuServlet")
public class menuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int resId=Integer.parseInt(req.getParameter("restaurantId"));
		System.out.println(resId);
		MenuDAO menuDAO=new MenuDAOImpl();
		ArrayList<Menu> menuList=menuDAO.getMenuByRestaurantId(resId);
		HttpSession session=req.getSession();
		session.setAttribute("MENU",menuList);
		resp.sendRedirect("menu.jsp");
	}
}
