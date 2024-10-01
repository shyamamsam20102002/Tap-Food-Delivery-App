package com.tap.dto;

public class CartItem {
	private int itemId;
	private int restaurant;
	private String name;
	private int quantity;
	private float price;
	public CartItem(int itemId, int restaurant, String name, int quantity, float price) {
		super();
		this.itemId = itemId;
		this.restaurant = restaurant;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public CartItem() {
		super();
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurant=" + restaurant + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
	
}
