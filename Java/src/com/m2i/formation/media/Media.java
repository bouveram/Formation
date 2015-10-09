package com.m2i.formation.media;

import java.util.Date;

public class Media extends Item {
	
	private String title;
	private String lang;
	private Editor publisher;
	private Author[] authors = new Author[10];
	private Date date;
	private int nbAuthor = 0;
	
	public String getTitle() {
		return title;
	}
	public String getLang() {
		return lang;
	}
	public Editor getPublisher() {
		return publisher;
	}
	public Date getDate() {
		return date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public void setPublisher(Editor publisher) {
		this.publisher = publisher;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getVATPrice(){
		return getPrice()*1.2;
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
