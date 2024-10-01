package com.tap.dto;

public class User {
	private int userid;
	private String email;
	private String username;
	private String password;
	private String address;
	private String phonenumber;
	public User()
	{
		
	}
	public User(String email, String username, String password, String address, String phonenumber)
	{
		
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
	}
	public User(int userid, String email,String username, String password, String address, String phonenumber) {
		
		this.userid = userid;
		this.email = email;
		this.username=username;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUserid() {
		return userid;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", phonenumber=" + phonenumber + "]";
	}
	
	


}