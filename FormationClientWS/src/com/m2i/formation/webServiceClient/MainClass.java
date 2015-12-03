package com.m2i.formation.webServiceClient;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.m2i.formation.jsf.manageBeans.francois.BookBean;
import com.m2i.formation.jsf.managedBeans.maxime.BookTO;
import com.m2i.formation.jsf.webService.maxime.HelloService;
import com.m2i.formation.jsf.webService.maxime.HelloServiceServiceLocator;

public class MainClass {

	public static void main(String[] args) throws ServiceException, RemoteException {
		// TODO Auto-generated method stub
		HelloService service = new HelloServiceServiceLocator().getHelloService();

		System.out.println(service.getHello());

		BookTO book = service.getBook(1, "ceci est un test", 12.4);
		System.out.println(book.getId());
		System.out.println(book.getTitle());
		System.out.println(book.getPrice());

		book = service.getById(2);
		System.out.println(book.getId());
		System.out.println(book.getTitle());
		System.out.println(book.getPrice());
		
		com.m2i.formation.jsf.manageBeans.francois.HelloService serviceFran = 
				new com.m2i.formation.jsf.manageBeans.francois.HelloServiceServiceLocator().getHelloService();
		
		BookBean bookFran = serviceFran.getBookbyID(3);
		System.out.println(bookFran.getTitle());
	}

}
