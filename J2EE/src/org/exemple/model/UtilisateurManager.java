package org.exemple.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		this.cache.put(user.getId(),user);
	}
	
	public void remove(Utilisateur user) {
		this.cache.remove(user.getId(),user);
	}
	
	public void update(Utilisateur user) {
		this.cache.replace(user.getId(), user);
	}
	
	public Utilisateur getById(int id) {
		return this.cache.get(id);
	}
	
	public List<Utilisateur> getAll() {
		final List<Utilisateur> result = new ArrayList<>(this.cache.values());
		return result;
	}
}
