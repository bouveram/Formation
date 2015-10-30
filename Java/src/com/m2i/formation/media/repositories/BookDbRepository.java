package com.m2i.formation.media.repositories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.m2i.formation.media.entities.Book;
import com.m2i.formation.media.entities.Editor;

public class BookDbRepository implements IRepository<Book> {

	private Properties properties = new Properties();
	private Connection conn;
	private String uri;
	
	
	public BookDbRepository() throws FileNotFoundException, IOException, SQLException {
		
		properties.load(new FileInputStream("src/test.properties"));
		uri = getUri();
		conn = DriverManager.getConnection(uri,
				properties.getProperty("JDBC_USER"),
				properties.getProperty("JDBC_PASS"));
	}
	
	@Override
	public String getUri() {
		// TODO Auto-generated method stub
		return properties.getProperty("JDBC_URL");
	}

	@Override
	public void setUri(String uri) {
		// TODO Auto-generated method stub
		this.uri = uri;
	}

	@Override
	public List<Book> getAll() throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt;
		ResultSet rs;
		List<Book> result = new ArrayList<Book>();
		
		stmt = conn.createStatement();
		
		String strSQL = "select a.*,b.name,b.id as publiID from media as a left outer join publisher as b"
				+ " on a.id_publisher = b.id where a.type = 0;";
		
		rs = stmt.executeQuery(strSQL);
		
		while(rs.next()) {
			Book b = new Book();
			Editor editor = new Editor();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			b.setNbPage(rs.getInt("nbPage"));
			editor.setId(rs.getInt("publiId"));
			editor.setName(rs.getString("name"));
			b.setPublisher(editor);
			result.add(b);
		}
		
		stmt.close();
		rs.close();
		
		return result;
	}

	@Override
	public Book getById(int id) throws IOException, SQLException {
		Statement stmt;
		ResultSet rs;
		Book b = null;
		
		stmt = conn.createStatement();
		
		String strSQL = "select a.*,b.name,b.id as publiID from media as a left outer join publisher as b"
				+ " on a.id_publisher = b.id where a.type = 0 and a.id = " + id + ";";
		
		rs = stmt.executeQuery(strSQL);
		
		while(rs.next()) {
			b = new Book();
			Editor editor = new Editor();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			b.setNbPage(rs.getInt("nbPage"));
			editor.setId(rs.getInt("publiId"));
			editor.setName(rs.getString("name"));
			b.setPublisher(editor);
		}
		
		stmt.close();
		rs.close();
		
		return b;
	}

	@Override
	public List<Book> getByPrice(double price) throws IOException, SQLException {
		Statement stmt;
		ResultSet rs;
		List<Book> result = new ArrayList<Book>();
		
		stmt = conn.createStatement();
		
		String strSQL = "select a.*,b.name,b.id as publiID from media as a left outer join publisher as b"
				+ " on a.id_publisher = b.id where a.type = 0 and a.price <= " + price + ";";
		
		rs = stmt.executeQuery(strSQL);
		
		while(rs.next()) {
			Book b = new Book();
			Editor editor = new Editor();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			b.setNbPage(rs.getInt("nbPage"));
			editor.setId(rs.getInt("publiId"));
			editor.setName(rs.getString("name"));
			b.setPublisher(editor);
			result.add(b);
		}
		
		stmt.close();
		rs.close();
				
		return result;
	}

	@Override
	public List<Book> getByTitle(String word) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
