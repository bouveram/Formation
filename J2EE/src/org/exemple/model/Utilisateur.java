package org.exemple.model;

public class Utilisateur {

	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String toJson(){
		StringBuffer sb = new StringBuffer();
		sb.append("{\n")
		.append("\"id\":\"").append(this.id).append("\",\n")
		.append("\"lastname\":\"").append(this.nom).append("\",\n")
		.append("\"firstname\":\"").append(this.prenom).append("\",\n")
		.append("\"address\":\"").append(this.adresse).append("\"\n")
		.append("}");
		return sb.toString();
	}
	public String toXml(){
		StringBuffer sb = new StringBuffer();
		sb.append("<user>\n")
		.append("<id>").append(this.id).append("</id>\n")
		.append("<lastname>").append(this.nom).append("</lastname>\n")
		.append("<firstname>").append(this.prenom).append("<firstname>\n")
		.append("<address>").append(this.adresse).append("</address>\n")
		.append("</user>");
		return sb.toString();
	}
	

}
