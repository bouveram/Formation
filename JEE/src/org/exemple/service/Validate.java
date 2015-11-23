package org.exemple.service;

import java.sql.*;

import org.exemple.connection.SqlConnection;
import org.exemple.model.Utilisateur;

public class Validate {
	
	public static Utilisateur checkUser(String email,String pass) 
	{
		boolean st = false;
		Utilisateur user = null;
		try{
			Connection conn = SqlConnection.getInstance().getConnection();
			PreparedStatement ps =conn.prepareStatement
					("select * from user where firstname=? and lastname=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				user= new Utilisateur();
				user.setId(rs.getInt("id"));
				user.setPrenom(rs.getString("firstname"));
				user.setNom(rs.getString("lastname"));
				user.setAdresse(rs.getString("adress"));
			}
			rs.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;                 
	}   
}
