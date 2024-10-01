package com.tap.dao;

import java.util.ArrayList;

import com.tap.dto.OrderTable;

public interface OrderTableDAO {
	int addOrder(OrderTable o);
	ArrayList<OrderTable> getAllOrders();
	OrderTable getSpecificOrder(int orderId);
}
