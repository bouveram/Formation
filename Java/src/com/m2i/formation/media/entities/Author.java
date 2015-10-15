package com.m2i.formation.media.entities;


public class Author implements IEntity {
	
	private String firstName;
	private String lastName;
	private int id;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
