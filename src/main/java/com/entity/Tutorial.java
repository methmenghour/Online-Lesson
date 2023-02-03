package com.entity;

public class Tutorial {


	private int id;
	private String title;
	private String decription;
	private String example;
	public Tutorial(int id, String title, String decription, String example) {
		super();
		this.id = id;
		this.title = title;
		this.decription = decription;
		this.example = example;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tutorial(String title, String decription, String example) {
		super();
		this.title = title;
		this.decription = decription;
		this.example = example;
	}


}
