package com.tap.dao;

import java.util.ArrayList;

import com.tap.dto.OrderItem;

public interface OrderItemDAO {
	int addOrder(OrderItem o);
	ArrayList<OrderItem> getAllOrders();
	OrderItem getSpecificOrder(int orderItemId);
	ArrayList<OrderItem> getSpecificOrderByOrderid(int orderId);
}
