package com.tap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.connector.MyConnection;
import com.tap.dto.Menu;

public class MenuDAOImpl implements MenuDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	ArrayList<Menu> al=new ArrayList<Menu>();
	private Menu menu;
	private static final String ADD_MENU="insert into menu(restaurantId, ItemName, price, description, isAvailable, imgPath) values(?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from menu";
	private static final String SELECT_ON_MENUID="select * from menu where menuId=?";
	private static final String SELECT_ON_RESTAURANTID="select * from menu where restaurantId=?";
	private static final String UPDATE_ON_ID="update user set restaurantId=?,ItemName=?,price=?,description=?,isAvailable=?,imgpath=?  where menuId=?";

	private static final String DELETE_ON_ID="delete from user where menuId=?";
	

	public MenuDAOImpl() {
		try {
			con=MyConnection.requestConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int addMenu(Menu m) {
		try {
			pstmt=con.prepareStatement(ADD_MENU);
			pstmt.setInt(1,m.getRestaurantId() );
			pstmt.setString(2, m.getItemName());
			pstmt.setFloat(2, m.getPrice());
			pstmt.setString(2, m.getDescription());
			pstmt.setString(2, m.getIsAvailable());
			pstmt.setString(2, m.getImgPath());
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	public List<Menu> getAllMenu() {
		try
		{
			 stmt=con.createStatement();
			  res = stmt.executeQuery(SELECT_ALL);
			  al=extractUserFromResultSet(res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	public Menu getMenu(int menuId) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_MENUID);
			pstmt.setInt(1,menuId );
			res=pstmt.executeQuery();
			al=extractUserFromResultSet(res);
			menu=al.get(0);
 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return menu;
	}

	
	public ArrayList<Menu> getMenuByRestaurantId(int RestaurantId) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_RESTAURANTID);
			pstmt.setInt(1, RestaurantId);
			res=pstmt.executeQuery();
			al=extractUserFromResultSet(res);
 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

	
	public int updateMenu(Menu u) {
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_ID);
			
			pstmt.setInt(1, u.getRestaurantId());
			pstmt.setString(2, u.getItemName());
			pstmt.setFloat(3, u.getPrice());
			pstmt.setString(4, u.getDescription());
			pstmt.setString(5, u.getIsAvailable());
			pstmt.setString(6, u.getImgPath());
			status=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public int deleteMenu(int menuId) {
		try
		{
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1,menuId);
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	ArrayList<Menu> extractUserFromResultSet(ResultSet res){
		try {
			while(res.next()) 
			{
				al.add(new Menu(res.getInt("menuId"),res.getInt("restaurantId"),
						res.getString("ItemName"),res.getFloat("price"),res.getString("description"),
						res.getString("isAvailable"),res.getString("imgpath")));
				 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}