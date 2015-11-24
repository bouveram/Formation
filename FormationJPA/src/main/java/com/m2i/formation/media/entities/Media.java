package com.m2i.formation.media.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity //veux dire classe persistante
@Table(name="media") //Indique la table où sauvegarder la classe
@NamedQuery(name="Media.findAll", query="SELECT m FROM Media m")
public class Media implements Serializable, IEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Identity = auto-increments
	@Column(unique=true, nullable=false)
	private int id;

	private Integer category;

	@Temporal(TemporalType.DATE)
	private Date dateSortie;

	@Column(nullable=false) //Facultatif
	private int id_Publisher;

	@Column(length=25)
	private String isbn;

	@Column(length=25)
	private String lang;

	private Integer nbPage;

	private Integer nbTrack;

	@Column(nullable=false)
	private float price;

	@Column(nullable=false, length=25)
	private String title;

	@Column(nullable=false)
	private int type;

	public Media() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public Date getDateSortie() {
		return this.dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getId_Publisher() {
		return this.id_Publisher;
	}

	public void setId_Publisher(int id_Publisher) {
		this.id_Publisher = id_Publisher;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getNbPage() {
		return this.nbPage;
	}

	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}

	public int getNbTrack() {
		return this.nbTrack;
	}

	public void setNbTrack(int nbTrack) {
		this.nbTrack = nbTrack;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}