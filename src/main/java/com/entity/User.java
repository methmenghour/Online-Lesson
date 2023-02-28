package com.entity;

public class User {
	private int id;
	private String UserName;
	private String Password;
	public User(String userName, String password) {
		super();
		UserName = userName;
		Password = password;
	}
	public User(int id, String userName, String password) {
		super();
		this.id = id;
		UserName = userName;
		Password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
