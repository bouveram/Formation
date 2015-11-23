package org.exemple.model;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Salutation {

	@WebMethod
	public String bonjour() {
		return "hello boby chabrout";
	}
	
	@WebMethod
	public List<Utilisateur> getAllUser() {
		return UtilisateurManager.getInstance().getAll();
	}
	
}
