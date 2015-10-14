package com.m2i.formation.media.repositories;

import java.io.IOException;
import java.util.List;

import com.m2i.formation.media.entities.*;

public interface IRepository<T extends Book> { // IRepository<T> where T:Media
	
	String getUri();
	
	void setUri(String uri);
	
	List<T> getAll() throws IOException;
	
	T getById(int id) throws IOException ;
	
	List<T> getByPrice(double price) throws IOException ;
	
	List<T> getByTitle(String word) throws IOException ;
}
