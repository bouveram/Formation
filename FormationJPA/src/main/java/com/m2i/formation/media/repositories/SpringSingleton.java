package com.m2i.formation.media.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringSingleton {

	public SpringSingleton() {}
	
	private static XmlBeanFactory spring = null;
	
	public static synchronized XmlBeanFactory getXBF(){
		if(spring == null) {
			spring = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		}
		return spring;
	}

}
