package org.exemple.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {
	
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/jee";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "root";
	private static Connection conn = null;
	
	
	private static final SqlConnection instance = new SqlConnection();
	public static SqlConnection getInstance(){
		return instance;
	}
	
	private SqlConnection() {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
	
}
