package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.MenuDAO;
import com.tap.dao.MenuDAOImpl;
import com.tap.dto.Cart;
import com.tap.dto.CartItem;
import com.tap.dto.Menu;

@SuppressWarnings("serial")
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	public CartItem item;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		
		if(cart==null)
		{
			cart=new Cart();
			session.setAttribute("cart",cart);
		}
		
		String action=request.getParameter("action");
		if("add".equals(action))
		{
			addItemToCart(request,cart);	
		}
		else if("update".equals(action))
		{
			updateCardItem(request,cart);
		}
		else if("remove".equals(action))
		{
			removeItemFromCart(request,cart);
		}
		session.setAttribute("item",item);
		session.setAttribute("items",Cart.items);
		response.sendRedirect("cart.jsp");
	}
	private void removeItemFromCart(HttpServletRequest request, Cart cart) {

		int itemId=Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);		

	}
	private void updateCardItem(HttpServletRequest request, Cart cart) {

		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		MenuDAO menuDAO=new MenuDAOImpl();
		Menu menuItem=menuDAO.getMenu(itemId);
		
		if(menuItem!=null)
		{
			item=new CartItem(
					menuItem.getMenuId(),
					menuItem.getRestaurantId(),
					menuItem.getItemName(),
					quantity,menuItem.getPrice()
				);
			cart.updateItem(itemId,quantity);		
		}
		
	}
	private void addItemToCart(HttpServletRequest request,Cart cart)
	{
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		MenuDAO menuDAO=new MenuDAOImpl();
		Menu menuItem=menuDAO.getMenu(itemId);
		
//		session.setAttribute("restaurentId",menuItem.getRestaurantId());
		
		if(menuItem!=null)
		{
			item=new CartItem(
					menuItem.getMenuId(),
					menuItem.getRestaurantId(),
					menuItem.getItemName(),
					quantity,menuItem.getPrice()
				);
			cart.addItem(item);		
		}
	}

}
