package com.tap.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.connector.MyConnection;
import com.tap.dao.OrderHistoryDAO;
import com.tap.dao.OrderHistoryDAOImpl;
import com.tap.dao.OrderItemDAO;
import com.tap.dao.OrderItemDAOImpl;
import com.tap.dao.OrderTableDAO;
import com.tap.dao.OrderTableDAOImpl;
import com.tap.dto.CartItem;
import com.tap.dto.Menu;
import com.tap.dto.OrderHistory;
import com.tap.dto.OrderItem;
import com.tap.dto.OrderTable;
import com.tap.dto.User;

@WebServlet("/InsertOrdersTables")
public class InsertOrdersTables extends HttpServlet {

    private PreparedStatement pstmt;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HashMap<Integer, CartItem> itemsofcart = (HashMap<Integer, CartItem>) session.getAttribute("items");
        if (itemsofcart == null || itemsofcart.isEmpty()) {
            resp.sendRedirect("cart.jsp"); // Redirect to cart if no items
            return;
        }

        ArrayList<Menu> MenuList = (ArrayList<Menu>) session.getAttribute("MENU");
        User user = (User) session.getAttribute("loggedInUser");

        if (MenuList == null || user == null) {
            resp.sendRedirect("login.jsp"); // Redirect if user or menu list is missing
            return;
        }

        int maxorderId = 0;
        int i = 0;
        for (Map.Entry<Integer, CartItem> entry : itemsofcart.entrySet()) {
            CartItem value = entry.getValue();
            int resId = MenuList.get(i).getRestaurantId();
            i++;
            int userId = user.getUserid();
            float price = value.getPrice() * value.getQuantity();

            OrderTable otobj = new OrderTable();
            otobj.setUserId(userId);
            otobj.setRestaurantId(resId);
            otobj.setTotalAmount(price);
            otobj.setStatus("pending");
            otobj.setPaymentMode("cash");

            OrderTableDAO otd = new OrderTableDAOImpl();
            if (otd.addOrder(otobj) != 1) {
                System.out.println("Failed to insert in orderTable");
                resp.sendRedirect("error.jsp"); // Redirect if there is an error
                return;
            }

            try (Connection con = MyConnection.requestConnection()) {
                pstmt = con.prepareStatement("SELECT MAX(orderId) AS maxOrderId FROM ordertable");
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    maxorderId = rs.getInt("maxOrderId"); // Retrieve the maximum orderId
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                resp.sendRedirect("error.jsp"); // Redirect on exception
                return;
            }

            float subTotal = 0;
            int j = 0;
            int menuId = MenuList.get(j).getMenuId();
            j++;
            int Quantity = value.getQuantity();
            subTotal = Quantity * value.getPrice();

            OrderItem oiobj = new OrderItem();
            oiobj.setOrderId(maxorderId);
            oiobj.setMenuId(menuId);
            oiobj.setQuantity(Quantity);
            oiobj.setSubTotal(subTotal);
            OrderItemDAO oiDAO = new OrderItemDAOImpl();

            if (oiDAO.addOrder(oiobj) != 1) {
                System.out.println("Failed to insert in orderItemTable");
                resp.sendRedirect("error.jsp"); // Redirect if there is an error
                return;
            }

            OrderHistory ohobj = new OrderHistory();
            ohobj.setOrderId(maxorderId);
            ohobj.setUserId(user.getUserid());
            ohobj.setTotalAmount(price);
            ohobj.setStatus("pending");

            OrderHistoryDAO ohDAO = new OrderHistoryDAOImpl();

            if (ohDAO.addOrderHistory(ohobj) != 1) {
                System.out.println("Failed to update orderHistory table");
                resp.sendRedirect("error.jsp"); // Redirect if there is an error
                return;
            }
        }

        // Ensure response redirection happens only after all operations are completed
        resp.sendRedirect("OrdersCompleted.jsp");
    }
}
