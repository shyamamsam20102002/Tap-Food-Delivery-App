


package com.tap.dao;

import java.util.ArrayList;

import com.tap.dto.User;

public interface UserDAO {
	int addUser(User u);
	ArrayList<User> getAllUsers();
	
	int updateUser(User u);
	int deleteUser(String email);
	User getUser(String email);
	int updateUserByUid(User u, int userid);
	

}

