package com.tap.dto;
public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private int deliveryTime;
	private String cuisineType;
	private String address;
	private float rating;
	private String isActive;
	private int adminId;
	private String imgPath;
	public Restaurant()
	{
		super();
	}
	public Restaurant(int restaurantId,String restaurantName,int deliverTime,String cuisineType,
			String address,float rating,String isActive,int adminId,String imgPath)
	{
		super();
		this.restaurantId=restaurantId;
		this.restaurantName=restaurantName;
		this.deliveryTime=deliveryTime;
		this.cuisineType=cuisineType;
		this.address=address;
		this.rating=rating;
		this.isActive=isActive;
		this.adminId=adminId;
		this.imgPath=imgPath;
	}
	public Restaurant(String restaurantName,int deliverTime,String cuisineType,String address,float rating,String isActive,int adminId,String imgPath)
	{
		super();
		this.restaurantName=restaurantName;
		this.deliveryTime=deliveryTime;
		this.cuisineType=cuisineType;
		this.address=address;
		this.rating=rating;
		this.isActive=isActive;
		this.adminId=adminId;
		this.imgPath=imgPath;
	}
	public void setRestaurantId(int restaurantid)
	{
		this.restaurantId=restaurantid;
	}
	public int getRestaurantId()
	{
		return restaurantId;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public float getRating() {
		return rating;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getImgPath() {
		return imgPath;
	}
}