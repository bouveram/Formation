package com.m2i.formation.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

	private EMF(){}

	private static EMF instance = null;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationJPA");

	public static synchronized EMF getInstance(){
		if(instance == null) {
			instance = new EMF();
		}
		return instance;
	}
	
	public static synchronized EntityManagerFactory getEmf(){
		return emf;
	}
}
