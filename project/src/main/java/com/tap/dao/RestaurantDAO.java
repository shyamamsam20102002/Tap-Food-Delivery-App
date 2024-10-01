package com.tap.dao;

import java.util.List;

import com.tap.dto.Restaurant;

public interface RestaurantDAO {

	int addRestaurant(Restaurant r);
	List<Restaurant> getAllRestaurants();
	Restaurant getSpecificRestaurant(int restaurantId);
	int updateRestaurant(Restaurant r);
	int deleteRestaurant(int restaurantId);
}
