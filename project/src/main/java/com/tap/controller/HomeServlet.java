package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tap.dao.*;

import com.tap.dto.Restaurant;


@SuppressWarnings("serial")
@WebServlet("/home1")
public class HomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAO restaurantdao=new RestaurantDAOImpl();
		List<Restaurant> restaurantList = restaurantdao.getAllRestaurants();
		//System.out.println(restaurantList);
		HttpSession session=req.getSession();
		session.setAttribute("restaurantList", restaurantList);
		resp.sendRedirect("home.jsp");
	}
    

}
