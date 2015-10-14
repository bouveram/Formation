package com.m2i.formation.media.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.*;

import com.m2i.formation.media.entities.Book;

public class BookRepository implements IBookRepository{

	private String uri;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public List<Book> getAll() throws IOException {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		BufferedReader br = new BufferedReader(new FileReader(uri));
		String line;
		line = br.readLine(); //delete first Line
		line = br.readLine();
		while(line!=null) {

			Book b = new Book();
			b=getBookFromCSV(line);
			
			bookList.add(b);
			line = br.readLine();
		}
		br.close();
		return bookList;
	}

	@Override
	public Book getById(int id) throws IOException {
		// TODO Auto-generated method stub
		Book findedBook = new Book();
		BufferedReader br = new BufferedReader(new FileReader(uri));
		String line;
		line = br.readLine(); //delete first Line
		line = br.readLine();
		while(line!=null) {

			Book b = new Book();
			b=getBookFromCSV(line);
			
			if(b.getId()==id) {
				findedBook = b;
				break;
			}
			line = br.readLine();
		}
		br.close();
		
		return findedBook;
	}

	@Override
	public List<Book> getByPrice(double price) throws IOException {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		BufferedReader br = new BufferedReader(new FileReader(uri));
		String line;
		line = br.readLine(); //delete first Line
		line = br.readLine();
		while(line!=null) {
			
			Book b = new Book();
			b=getBookFromCSV(line);
			
			if(b.getPrice()<=price)
				bookList.add(b);
			line = br.readLine();
		}
		br.close();
		return bookList;
	}

	@Override
	public List<Book> getByTitle(String word) throws IOException {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile(word);
	    Matcher matcher;
		
        matcher = pattern.matcher("Hugo Etiévant");
	    
		List<Book> bookList = new ArrayList<Book>();
		BufferedReader br = new BufferedReader(new FileReader(uri));
		String line;
		line = br.readLine(); //delete first Line
		line = br.readLine();
		while(line!=null) {
			
			Book b = new Book();
			b=getBookFromCSV(line);
			
			matcher = pattern.matcher(b.getTitle());
			while(matcher.find()) {
				bookList.add(b);
			}
			line = br.readLine();
		}
		br.close();
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
