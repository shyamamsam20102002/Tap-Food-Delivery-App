package com.tap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tap.connector.MyConnection;
import com.tap.dto.OrderTable;

public class OrderTableDAOImpl implements OrderTableDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet res;
	ArrayList<OrderTable> al=new ArrayList<OrderTable>();
	private OrderTable orders;
	private static final String ADD_ORDER="insert into ordertable(restaurantId, userId, totalAmount, status, paymentMode) values(?,?,?,?,?)";
	private static final String GET_ALL="select * from ordertable";
	private static final String GET_SPECIFIC_ORDER="select * from ordertable where orderId=?";
	
	public OrderTableDAOImpl()
	{
		try {
			con=MyConnection.requestConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public int addOrder(OrderTable o) {
		try {
			pstmt=con.prepareStatement(ADD_ORDER);
			pstmt.setInt(1, o.getRestaurantId());
			pstmt.setInt(2, o.getUserId());
			pstmt.setFloat(3, o.getTotalAmount());
			pstmt.setString(4, o.getStatus());
			pstmt.setString(5, o.getPaymentMode());
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}

	
	public ArrayList<OrderTable> getAllOrders() {
		try {
			pstmt=con.prepareStatement(GET_ALL);
			res=pstmt.executeQuery();
			al=extractAllOrders(res);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return al;
	}

	
	public OrderTable getSpecificOrder(int orderId) {
		try {
			pstmt=con.prepareStatement(GET_SPECIFIC_ORDER);
			pstmt.setInt(1, orderId);
			res=pstmt.executeQuery();
			al=extractAllOrders(res);
			orders=al.get(0);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	ArrayList<OrderTable> extractAllOrders(ResultSet res)
	{
		try {
			al.add(new OrderTable(res.getInt("orderId"),res.getInt("restaurantId"),res.getInt("userId"),res.getFloat("totalAmount"),res.getString("status"),res.getString("paymentMode"))); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}


}