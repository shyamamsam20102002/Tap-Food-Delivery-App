package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.OrderHistoryDAO;
import com.tap.dao.OrderHistoryDAOImpl;
import com.tap.dto.OrderHistory;
import com.tap.dto.User;


@WebServlet("/OrdersHistory")
public class OrdersHistory extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("loggedInUser");
		System.out.print(user.getUserid());
		
		OrderHistoryDAO ohDAO=new OrderHistoryDAOImpl();
		ArrayList<OrderHistory> historyList=ohDAO.getSpecificOrderHistoryByUserId(user.getUserid());
		
		session.setAttribute("OrderHistory123", historyList);
//		System.out.println(session.getAttribute("HistoryList"));
		resp.sendRedirect("OrderHistory.jsp");
	}
}
