package com.tap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.connector.MyConnection;
import com.tap.dto.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	ArrayList<Restaurant> al=new ArrayList<Restaurant>();
	private Restaurant restaurant;
	


	public RestaurantDAOImpl() {
		try {
			con=MyConnection.requestConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static final String ADD_RESTAURANT="insert into restaurant(restaurantName,deliveryTime,cuisineType,address,ratings,isActive,adminId,imgpath) values(?,?,?,?,?,?,?,?)";
	private static final String GET_ALL="select * from restaurant";
	private static final String GET_ON_ID="select * from restaurant where restaurantId=?";
	private static final String UPDATE_ON_ID="update restaurant set restaurantName=?,deliveryTime=?,cuisineType=?,address=?,ratings=?,isActive=?,adminId=?,imgpath=? where  restaurantId=?";
	private static final String DELETE_ON_ID="delete from restaurant where restaurantId=?";
	
	
	
	

	
	public int addRestaurant(Restaurant r) {
		try {
			pstmt=con.prepareStatement(ADD_RESTAURANT);
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRating());
			pstmt.setString(6, r.getIsActive());
			pstmt.setInt(7, r.getAdminId());
			pstmt.setString(8, r.getImgPath());
			
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	
	public List<Restaurant> getAllRestaurants() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALL);
			al=extractAllRestaurants(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}


	public Restaurant getSpecificRestaurant(int restaurantId) {
		try {
			pstmt=con.prepareStatement(GET_ON_ID);
			res=pstmt.executeQuery();
			al=extractAllRestaurants(res);
			restaurant=al.get(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return restaurant;
	}

	
	public int updateRestaurant(Restaurant r) {
		try {
			pstmt=con.prepareStatement(UPDATE_ON_ID);
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRating());
			pstmt.setString(6, r.getIsActive());
			pstmt.setInt(7, r.getAdminId());
			pstmt.setString(8, r.getImgPath());
			pstmt.setInt(9, r.getRestaurantId());
			
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	
	public int deleteRestaurant(int restaurantId) {
		try {
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1, restaurantId);
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	ArrayList<Restaurant> extractAllRestaurants(ResultSet res){
		try {
			while(res.next()) {
				
					al.add(new Restaurant(res.getInt("restaurantId"),res.getString("restaurantName"),res.getInt("deliveryTime"),res.getString("cuisineType"),res.getString("address"),res.getFloat("ratings"),res.getString("isActive"),res.getInt("adminId"),res.getString("imgpath")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

}