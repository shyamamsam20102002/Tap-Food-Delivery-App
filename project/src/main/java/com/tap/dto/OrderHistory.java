package com.tap.dto;

public class OrderHistory {
	private int orderHistoryId;
	private int orderId;
	private int userId;
	private float totalAmount;
	private String status;
	public OrderHistory()
	{
		
	}
	public OrderHistory( int orderId, int userId, float totalAmount, String status) {
		
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderHistory(int orderHistoryId, int orderId, int userId, float totalAmount, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderId() {
		return orderId;
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
	
	


}