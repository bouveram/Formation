package org.exemple.model;

import java.util.ArrayList;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exemple.connection.SqlConnection;

public class UtilisateurManager {

	private static final UtilisateurManager instance = new UtilisateurManager();
	public static final UtilisateurManager getInstance(){
		return UtilisateurManager.instance;
	}
	
	
	private Map<Integer, Utilisateur> cache = new HashMap<>();
	
	private UtilisateurManager() {
		Utilisateur u1 = new Utilisateur();
		u1.setId(10);
		u1.setPrenom("Alice");
		u1.setNom("Saglice");
		u1.setAdresse("53 rue mouillé");
		this.add(u1);
		
		Utilisateur u2 = new Utilisateur();
		u2.setId(20);
		u2.setPrenom("Jean");
		u2.setNom("Peche");
		u2.setAdresse("35 rue du lac");
		this.add(u2);
		
		Utilisateur u3 = new Utilisateur();
		u3.setId(30);
		u3.setPrenom("Claude");
		u3.setNom("Reine");
		u3.setAdresse("98 rue de l'arbre");
		this.add(u3);
	}
	
	
	public void add(Utilisateur user) {
		try {
			PreparedStatement stmt = SqlConnection.getInstance().getConnection().prepareStatement("insert into user values(?,?,?,?);");
			stmt.setInt(1,user.getId());
			stmt.setString(2, user.getPrenom());
			stmt.setString(3, user.getNom());
			stmt.setString(4, user.getAdresse());
			
			int rs = stmt.executeUpdate();
			
			if(stmt!=null)
				stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(Utilisateur user) {
		try {
			PreparedStatement stmt = SqlConnection.getInstance().getConnection().prepareStatement("delete from user WHERE id=?;");
			stmt.setInt(1,user.getId());
			
			int rs = stmt.executeUpdate();
			
			if(stmt!=null)
				stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Utilisateur user) {
		
		try {
			PreparedStatement stmt = SqlConnection.getInstance().getConnection().prepareStatement("UPDATE user SET lastname=?,firstname=?,adress=? WHERE id=?;");
			stmt.setInt(4,user.getId());
			stmt.setString(1, user.getPrenom());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getAdresse());
			
			int rs = stmt.executeUpdate();
			
			if(stmt!=null)
				stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Utilisateur getById(int id) {
		Utilisateur user = new Utilisateur();
		try {
			PreparedStatement stmt = SqlConnection.getInstance().getConnection().prepareStatement("select * from user where id = ?;");
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setPrenom(rs.getString("firstname"));
				user.setNom(rs.getString("lastname"));
				user.setAdresse(rs.getString("adress"));
			}
			rs.close();
			
			if(stmt!=null)
				stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public List<Utilisateur> getAll() {
		//UtilisateurManager.connection();
		final List<Utilisateur> result = new ArrayList<>();
		try {
			Connection conn = SqlConnection.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user;");
			
			while(rs.next()){
				Utilisateur user = new Utilisateur();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("lastname"));
				user.setPrenom(rs.getString("firstname"));
				user.setAdresse(rs.getString("adress"));
				result.add(user);
			}
			rs.close();
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
