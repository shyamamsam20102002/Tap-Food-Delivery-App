package com.tap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tap.connector.MyConnection;
import com.tap.dto.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet res;
	ArrayList<OrderItem> al=new ArrayList<OrderItem>();
	private OrderItem items;
	private static final String ADD_ORDER="insert into orderitem(orderId,menuId, quantity, subTotal) values(?,?,?,?)";
	private static final String GET_ALL="select * from orderitem";
	private static final String GET_SPECIFIC_ORDER="select * from orderitem where orderItemId=?";
	private static final String GET_SPECIFIC_ORDER_BYOID="select * from orderitem where orderId=?";

	public OrderItemDAOImpl() {

		try {
			con=MyConnection.requestConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public int addOrder(OrderItem o) {
		try {
			pstmt=con.prepareStatement(ADD_ORDER);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2, o.getMenuId());
			pstmt.setInt(3, o.getQuantity());
			pstmt.setFloat(4, o.getSubTotal());
			
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}


	public ArrayList<OrderItem> getAllOrders() {
		
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

	public OrderItem getSpecificOrder(int orderItemId) {
		try {
			pstmt=con.prepareStatement(GET_SPECIFIC_ORDER);
			pstmt.setInt(1, orderItemId);
			res=pstmt.executeQuery();
			al=extractAllOrders(res);
			items=al.get(0);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
		
	}
	ArrayList<OrderItem> extractAllOrders(ResultSet res)
	{
		try {
			while(res.next()) {
			al.add(new OrderItem(res.getInt("orderItemId"),res.getInt("orderId"),res.getInt("menuId"),res.getInt("quantity"),res.getFloat("subTotal")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}


	@Override
	public ArrayList<OrderItem> getSpecificOrderByOrderid(int orderId) {
		try {
			pstmt=con.prepareStatement(GET_SPECIFIC_ORDER_BYOID);
			pstmt.setInt(1, orderId);
			res=pstmt.executeQuery();
			al=extractAllOrders(res);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
		
	}

}