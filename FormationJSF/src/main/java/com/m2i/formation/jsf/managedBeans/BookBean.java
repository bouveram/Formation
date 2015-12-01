package com.m2i.formation.jsf.managedBeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="bookBean")
public class BookBean {

	private int id;
	private String Title;
	private double price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPriceVAT() {
		return price*1.05;
		
	}
	
}
