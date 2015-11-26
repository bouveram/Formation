package com.m2i.formation.media.repositories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSingleton {

	public SpringSingleton() {}
	
	private static ApplicationContext spring = null;
	
	public static synchronized ApplicationContext getXBF(){
		if(spring == null) {
			spring = new ClassPathXmlApplicationContext("spring.xml");
		}
		return spring;
	}

}
