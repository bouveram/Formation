package com.m2i.formation.media.entities;

public interface IItem {

	double getPrice();

	int getId();

	String getName();

	void setPrice(double price);

	void setId(int id);

	void setName(String name);

}