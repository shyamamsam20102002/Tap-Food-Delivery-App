package com.tap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tap.connector.MyConnection;
import com.tap.dto.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet res;
	ArrayList<OrderHistory> al=new ArrayList<OrderHistory>();
	public OrderHistory items;
	private static final String ADD_ORDER_HISTORY="insert into orderhistory(orderId, userid,totalAmount, status) values(?,?,?,?)";
	private static final String GET_ALL_ORDERS_HISTORY="select * from orderhistory";
	private static final String GET_SPECIFIC_ORDER_HISTORY="select * from orderhistory where orderHistoryId=?";
	private static final String GET_SPECIFIC_ORDER_HISTORY_BYUSERID="select * from orderhistory where userid=?";

	
	public OrderHistoryDAOImpl() {
		try {
			con=MyConnection.requestConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public int addOrderHistory(OrderHistory o) {
		
		try {
			pstmt=con.prepareStatement(ADD_ORDER_HISTORY);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2, o.getUserId());
			pstmt.setFloat(3, o.getTotalAmount());
			pstmt.setString(4, o.getStatus());
			
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}

	
	public ArrayList<OrderHistory> getAllOrdersHistory() {
		
		try {
			pstmt=con.prepareStatement(GET_ALL_ORDERS_HISTORY);
			res=pstmt.executeQuery();
			al=extractAllOrders(res);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return al;
	}

	
	public OrderHistory getSpecificOrderHistory(int orderHistoryId) {
		
		try {
			pstmt=con.prepareStatement(GET_SPECIFIC_ORDER_HISTORY);
			pstmt.setInt(1, orderHistoryId);
			res=pstmt.executeQuery();
			al=extractAllOrders(res);
			items=al.get(0);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	ArrayList<OrderHistory> extractAllOrders(ResultSet res)
	{
		try {
			while(res.next()) 
			{
			al.add(new OrderHistory(res.getInt("orderHistoryId"),
					res.getInt("orderId"),res.getInt("userId"),
					res.getFloat("totalAmount"),res.getString("status"))); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}


	
	

	@Override
	public ArrayList<OrderHistory> getAllOrderHistory() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<OrderHistory> getSpecificOrderHistoryByUserId(int userid) {
		try{
			pstmt=con.prepareStatement(GET_SPECIFIC_ORDER_HISTORY_BYUSERID);
			pstmt.setInt(1, userid);
			res=pstmt.executeQuery();
			al=extractAllOrders(res);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return al;
		

	}


}