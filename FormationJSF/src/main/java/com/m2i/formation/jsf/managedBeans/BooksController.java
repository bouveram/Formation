package com.m2i.formation.jsf.managedBeans;

import java.util.*;

import javax.faces.bean.ManagedBean;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.SpringSingleton;
import com.m2i.formation.media.services.MainService;

@ManagedBean(name="booksController")
public class BooksController {

	private List<BookBean> books = null;
	private int id;

	public String booksAllGet() {
		books = new ArrayList<BookBean>();
		BookBean b = null;
		for(Media m:SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getAll()){
			b = new BookBean();
			b.setTitle(m.getTitle());
			b.setId(m.getId());
			b.setPrice(m.getPrice());
			books.add(b);
		}
		return BookControllerEnum.index.toString();
	}
	
	public String getBookById() {
		books = new ArrayList<BookBean>();
		BookBean b = new BookBean();
		b.setId(id);
		b.setTitle(SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getById(id).getTitle());
		b.setPrice(SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getById(id).getPrice());
		books.add(b);
		return BookControllerEnum.index.toString();
	}

	public List<BookBean> getBooks() {
		return books;
	}

	public void setBooks(List<BookBean> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
