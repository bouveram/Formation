package com.m2i.formation.media.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.m2i.formation.media.entities.Book;

public class BookRepository implements IRepository<Book>{

	private String uri;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	private List<Book> cache = null;
	
	private List<Book> getCache() throws IOException {
		if(cache == null) {
			cache = cacheFactory();
		}
		return cache;
	}

	private List<Book> cacheFactory() throws IOException {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		Book b = new Book();
		BufferedReader br = new BufferedReader(new FileReader(uri));
		String line;
		line = br.readLine(); //delete first Line
		line = br.readLine();
		while(line!=null) {

			
			b=getBookFromCSV(line);
			
			bookList.add(b);
			line = br.readLine();
		}
		br.close();
		return bookList;
	}
	
	@Override
	public List<Book> getAll() throws IOException {
		return getCache();
	}

	@Override
	public Book getById(int id) throws IOException {
		// TODO Auto-generated method stub
		Book bookFound = null;
		
		for(Book b:getCache()) {
			if(b.getId()==id) {
				bookFound = b;
			}
		}
		return bookFound;
	}

	@Override
	public List<Book> getByPrice(double price) throws IOException {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		
		for(Book b:getCache()) {
			if(b.getPrice() <= price)
				bookList.add(b);
		}
		return bookList;
	}

	@Override
	public List<Book> getByTitle(String word) throws IOException {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		for(Book b:getCache()){
			if(b.getTitle().matches("(?i).*"+word+".*")) { //(?i) = CASE_INSENSITIVE
				bookList.add(b);
			}
		}
		return bookList;
	}
	
	public Book getBookFromCSV(String line) {
		
		Book b = new Book();
		StringTokenizer st = new StringTokenizer(line,";");
		b.setTitle(st.nextToken());
		b.setNbPage(Integer.parseInt(st.nextToken()));
		b.setPrice(Double.parseDouble(st.nextToken()));
		b.setId(Integer.parseInt(st.nextToken()));
		return b;
	}
	
}
