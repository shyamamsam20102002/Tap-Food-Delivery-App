package com.tap.dao;

import java.util.ArrayList;

import com.tap.dto.OrderHistory;

public interface OrderHistoryDAO {
	int addOrderHistory(OrderHistory o);
	ArrayList<OrderHistory> getAllOrderHistory();
	OrderHistory getSpecificOrderHistory(int orderItemId);
	ArrayList<OrderHistory> getSpecificOrderHistoryByUserId(int userid);
}
