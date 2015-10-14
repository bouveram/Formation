package com.m2i.formation.media.repositories;

import java.io.IOException;
import java.util.List;

import com.m2i.formation.media.entities.Book;

public interface IBookRepository {
	
	String getUri();
	
	void setUri(String uri);
	
	List<Book> getAll() throws IOException;
	
	Book getById(int id) throws IOException ;
	
	List<Book> getByPrice(double price) throws IOException ;
	
	List<Book> getByTitle(String word) throws IOException ;
}
