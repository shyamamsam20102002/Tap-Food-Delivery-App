package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.OrderItemDAO;
import com.tap.dao.OrderItemDAOImpl;
import com.tap.dto.OrderItem;


@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        System.out.println("\t"+orderId);
		
		OrderItemDAO oiDAO=new OrderItemDAOImpl();
		ArrayList<OrderItem> OrderItemList=oiDAO.getSpecificOrderByOrderid(orderId);
		
		HttpSession session=req.getSession();
		session.setAttribute("OrderItemList",OrderItemList);
		resp.sendRedirect("dispList.jsp");
	}

}
