package com.m2i.formation.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {

	private EMFSingleton(){}

	private static EntityManagerFactory emf = null;
	
	public static synchronized EntityManagerFactory getEmf(){
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("FormationJPA");
		}
		return emf;
	}
}
