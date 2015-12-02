package com.m2i.formation.jsf.managedBeans;


import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.BeansException;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.*;
import com.m2i.formation.media.services.*;

@ManagedBean(name="bookController")
public class BookController {
	
	private BookBean book = new BookBean();

	public String getSampleBook(){
		book.setId(1);
		book.setTitle("Sample");
		book.setPrice(13.54);
		return BookControllerEnum.index.toString();
	}
	
	public String insertBook(){
		Media m = new Media();
		m.setCategory(book.getType().ordinal());
		m.setTitle(book.getTitle());
		m.setPrice((float) book.getPrice());
		
		try {
			SpringSingleton.getXBF().getBean("mainService",MainService.class).addMedia(m);
		} catch (BeansException | ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println("Ca marche pas !");
		}
		return BookControllerEnum.index.toString();
	}
	
	public String getBookById(){
		//Appel à la base de données
		book.setTitle(SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getById(book.getId()).getTitle());
		book.setPrice(SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getById(book.getId()).getPrice());
		
		return BookControllerEnum.index.toString();
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}
	
	
}
