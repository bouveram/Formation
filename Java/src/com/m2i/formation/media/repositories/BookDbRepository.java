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
	private String uri;
	
	
	public BookDbRepository() throws FileNotFoundException, IOException, SQLException {
		
		properties.load(new FileInputStream("src/test.properties"));
		setUri(properties.getProperty("JDBC_URL"));
		
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(properties.getProperty("JDBC_DRIVER"));
		Connection conn = DriverManager.getConnection(uri,
				properties.getProperty("JDBC_USER"),
				properties.getProperty("JDBC_PASS"));
		return conn;
	}
	
	private List<Book> getByQuery(String sql) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		Statement stmt;
		ResultSet rs;
		List<Book> result = new ArrayList<Book>();
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
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
	public String getUri() {
		return uri;
	}

	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public List<Book> getAll() throws SQLException, ClassNotFoundException {
		 return getByQuery("select a.*,b.name,b.id as publiID from media as a left outer join publisher as b"
				+ " on a.id_publisher = b.id where a.type = 0;");
	}

	@Override
	public Book getById(int id) throws IOException, SQLException, ClassNotFoundException {
		List<Book> l = getByQuery("select a.*,b.name,b.id as publiID from media as a left outer join publisher as b"
				+ " on a.id_publisher = b.id where a.type = 0 and a.id = " + id + ";");
		Book b = null;
		if(l.size() > 0) {
			b = l.get(0);
		}
		return b;
	}

	@Override
	public List<Book> getByPrice(double price) throws IOException, SQLException, ClassNotFoundException {
		
		return getByQuery("select a.*,b.name,b.id as publiID from media as a left outer join publisher as b"
				+ " on a.id_publisher = b.id where a.type = 0 and a.price <= " + price + ";");
	}

	@Override
	public List<Book> getByTitle(String word) throws IOException, ClassNotFoundException, SQLException {
		
		return getByQuery("select a.*,b.name,b.id as publiID from media as a left outer join publisher as b"
				+ " on a.id_publisher = b.id where a.type = 0 and UPPER(a.title) like %" + word.toUpperCase() + "%;");
	}

}
