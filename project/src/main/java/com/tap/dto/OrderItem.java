package com.tap.dto;
public class OrderItem {
	private int orderItemId;
	private int orderId;
	private int menuId;
	private int quantity;
	private float subTotal;
	public OrderItem()
	{
		
	}
	public OrderItem(int orderId, int menuId, int quantity, float subTotal) {
		
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	
	public OrderItem(int orderItemId, int orderId, int menuId, int quantity, float subTotal) {
		
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	public float getSubTotal() {
		return subTotal;
	}
	

}