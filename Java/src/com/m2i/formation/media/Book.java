package com.m2i.formation.media;

public class Book extends Media {
	
	private int nbPage;
	private String isbn;
	private BookCategory category;
	
	
	public int getNbPage() {
		return nbPage;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public BookCategory getCategory() {
		return category;
	}
	
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}
	
	@Override
	public double getVATPrice(){
		return getPrice()*1.05;
	}
		
}
