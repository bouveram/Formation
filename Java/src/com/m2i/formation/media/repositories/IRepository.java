package com.m2i.formation.media.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.m2i.formation.media.entities.*;

public interface IRepository<T extends IEntity> { // IRepository<T> where T:Media
	
	String getUri();
	
	void setUri(String uri);
	
	List<T> getAll() throws IOException, SQLException, ClassNotFoundException;
	
	T getById(int id) throws IOException, SQLException, ClassNotFoundException ;
	
	List<T> getByPrice(double price) throws IOException, SQLException, ClassNotFoundException ;
	
	List<T> getByTitle(String word) throws IOException, ClassNotFoundException, SQLException ;
}
