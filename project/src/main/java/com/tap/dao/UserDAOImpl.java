package com.tap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.connector.MyConnection;
import com.tap.dto.User;

public class UserDAOImpl implements  UserDAO{

	Connection con;
	int status=0;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	User user;
	ArrayList<User> userList=new ArrayList<User>();
	private static final String ADD_USER="insert into user(email,username,password,address,phonenumber) values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from user";
	private static final String SELECT_on_EMAIL="select * from `user` where `email`=?";
	private static final String UPDATE_on_EMAIL="update user set username=?,password=?,address=?,phonenumber=? where email=?";
	private static final String UPDATE_USER="update user set username=?,password=?,address=?,phonenumber=? where userid=?";
	private static final String DELETE_on_EMAIL=" delete from user where email=?";
			
	public UserDAOImpl()
	{
		try
		{

			con=MyConnection.requestConnection();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int addUser(User u) {
		// TODO Auto-generated method stub
		try
		{
			pstmt=con.prepareStatement(ADD_USER);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getPhonenumber());
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(status);
		
		return status;
	}
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userList=extractUserFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
		
	}
	public User getUser(String email) {
		//System.out.println("email is 78 userdaoimp "+email);
		try
		{
			pstmt=con.prepareStatement(SELECT_on_EMAIL);
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			while(resultSet.next())
			{
				//ystem.out.println("Inside while 86");
				user = new User(resultSet.getInt("userid"),
				resultSet.getString("email"),
				resultSet.getString("username"),
				resultSet.getString("password"),
				resultSet.getString("address"),
				resultSet.getString("phonenumber"));
				//System.out.println(user);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
		
	}
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		try
		{
			 pstmt=con.prepareStatement(UPDATE_on_EMAIL);
				pstmt.setString(1, u.getUsername());
				pstmt.setString(2, u.getPassword());
				pstmt.setString(3, u.getAddress());
				pstmt.setString(4, u.getPhonenumber());
				pstmt.setString(5, u.getEmail());
				status=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public int deleteUser(String email) {
		// TODO Auto-generated method stub
		try
		{
			pstmt=con.prepareStatement(DELETE_on_EMAIL);
			pstmt.setString(1, email);
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	ArrayList<User> extractUserFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				userList.add(new User(
				resultSet.getInt("userid"),
				resultSet.getString("email"),
				resultSet.getString("username"),
				resultSet.getString("password"),
				resultSet.getString("address"),
				resultSet.getString("phonenumber")));
			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
	}
	@Override
	public int updateUserByUid(User u1,int userid) {

		try
		{
			 pstmt=con.prepareStatement(UPDATE_USER);
				pstmt.setString(1, u1.getUsername());
				pstmt.setString(2, u1.getPassword());
				pstmt.setString(3, u1.getAddress());
				pstmt.setString(4, u1.getPhonenumber());
				pstmt.setInt(5, userid);
				status=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	

}
