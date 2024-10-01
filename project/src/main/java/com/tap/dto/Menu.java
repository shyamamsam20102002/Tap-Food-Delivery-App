package com.tap.dto;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String ItemName;
	private float price;
	private String description;
	private String isAvailable;
	private String imgPath;
	public Menu()
	{
		
	}
	public Menu(int menuId,int restaurantId, String ItemName, float price, String description, String isAvailable,
			String imgPath) {
		super();
		
		this.menuId=menuId;
		this.restaurantId = restaurantId;
		this.ItemName = ItemName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	public Menu( int restaurantId, String ItemName, float price, String description, String isAvailable,
			String imgPath) {
		super();
		
		
		this.restaurantId = restaurantId;
		this.ItemName = ItemName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice() {
		return price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getImgPath() {
		return imgPath;
	}
	
	
	
	

}