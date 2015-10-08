package com.m2i.formation.media;

import java.util.Date;

public class Book {
	
	private String title;
	private int id;
	private Date date;
	private int nbPage;
	private String isbn;
	private double price;
	private String lang;
	private Editor publisher;
	private Author[] authors = new Author[10];
	private int nbAuthor = 0;
	private BookCategory category;
	
	public BookCategory getCategory() {
		return category;
	}
	public void setCategory(BookCategory category) {
		this.category = category;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @return the nbPage
	 */
	public int getNbPage() {
		return nbPage;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @param nbPage the nbPage to set
	 */
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public Editor getPublisher() {
		return publisher;
	}
	public void setPublisher(Editor publisher) {
		this.publisher = publisher;
	}
	public int getNbAuthor() {
		return nbAuthor;
	}
	public void addAuthor(Author author) {
		this.authors[nbAuthor++] = author;
	}
	public void displayAuthor() {
		if(nbAuthor != 0) {
			System.out.println("Contributor :");
			for(int i = 0; i< nbAuthor ; i++) {
				System.out.println(authors[i].getFirstName()+" "+authors[i].getLastName());
			}
		}
		else {
			System.out.println("No author for now !");
		}
	}
	
}
