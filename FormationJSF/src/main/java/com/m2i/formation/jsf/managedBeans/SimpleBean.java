package com.m2i.formation.jsf.managedBeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="simpleBean") //Crée un controleur, tout ce qui est public dans la classe est visible de la vue
public class SimpleBean {

	private int myInt;
	private String myString;
	
	
	public SimpleBean() {
		myInt = 3;
		myString = "Hello";
	}


	public int getMyInt() {
		return myInt;
	}


	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}


	public String getMyString() {
		return myString;
	}


	public void setMyString(String myString) {
		this.myString = myString;
	}
	
	

}
