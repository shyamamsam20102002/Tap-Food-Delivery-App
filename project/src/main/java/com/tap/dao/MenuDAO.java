package com.tap.dao;

import java.util.ArrayList;
import java.util.List;

import com.tap.dto.Menu;

public interface MenuDAO {
	int addMenu(Menu m);
	Menu getMenu(int menuId);
	ArrayList<Menu> getMenuByRestaurantId(int RestaurantId);
	int updateMenu(Menu m);
	List<Menu> getAllMenu();
	int deleteMenu(int menuId);
}
