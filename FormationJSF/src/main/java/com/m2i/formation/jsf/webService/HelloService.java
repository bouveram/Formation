package com.m2i.formation.jsf.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.m2i.formation.jsf.managedBeans.*;
import com.m2i.formation.jsf.managedBeans.TypeEnumeration;
import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.SpringSingleton;
import com.m2i.formation.media.services.MainService;

@WebService
public class HelloService {

	@WebMethod
	public String getHello(){
		return "Hello World";
	}
	
	@WebMethod
	public BookTO getBook(int id, String title, double price){
		BookTO b = new BookTO();
		b.setTitle(title);
		b.setId(id);
		b.setPrice(price);
		b.setType(1);
		return b;
	}
	
	@WebMethod
	public BookTO getById(int id){
		BookTO book = new BookTO();
		Media m = SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getById(id);
		book.setId(m.getId());
		book.setTitle(m.getTitle());
		book.setPrice(m.getPrice());
		book.setType(m.getCategory());
		return book;
	}
}
