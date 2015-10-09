package com.m2i.formation.geometry;

public class Point {
	
	private int x,y;
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	public void deplacer(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void afficher() {
		System.out.println("("+x+","+y+")");
	}
}
