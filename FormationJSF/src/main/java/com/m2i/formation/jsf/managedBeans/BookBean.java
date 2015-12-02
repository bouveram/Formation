package com.m2i.formation.jsf.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.*;

@ManagedBean(name="bookBean")
public class BookBean {

	private TypeEnumeration type;
	
	private int id;
	
	private String title;
	
	private double price;
	
	
	public TypeEnumeration getType() {
		return type;
	}
	public void setType(TypeEnumeration type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
