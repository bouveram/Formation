package com.m2i.formation.media.entities;

public interface IItem extends IEntity{

	double getPrice();

	String getName();

	void setPrice(double price);

	void setName(String name);

}