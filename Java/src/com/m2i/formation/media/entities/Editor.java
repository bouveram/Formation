package com.m2i.formation.media.entities;


public class Editor implements IEntity {

	private String name;
	private String siretNb;
	private double ca;
	private int id;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the siretNb
	 */
	public String getSiretNb() {
		return siretNb;
	}
	/**
	 * @return the cA
	 */
	public double getCA() {
		return ca;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param siretNb the siretNb to set
	 */
	public void setSiretNb(String siretNb) {
		this.siretNb = siretNb;
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
	
	/*
	 * Affiche des infos spécifiques lors du debugage
	 */
	public String toString() {
		return "Editor "+name;
	}

	
}
