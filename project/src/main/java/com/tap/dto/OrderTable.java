package com.tap.dto;

public class OrderTable {
	private int orderId;
	private int restaurantId;
	private int userId;
	private float totalAmount;
	private String status;
	private String paymentMode;
	public OrderTable()
	{
		
	}
	public OrderTable( int restaurantId, int userId, float totalAmount, String status, String paymentMode) {
		
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	public OrderTable(int orderId,int restaurantId, int userId, float totalAmount, String status, String paymentMode) {
		
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	
	

}