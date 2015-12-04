/**
 * HelloServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.m2i.formation.jsf.webService;

import com.m2i.formation.jsf.managedBeans.BookTO;
import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.SpringSingleton;
import com.m2i.formation.media.services.MainService;

public class HelloServiceSoapBindingImpl implements com.m2i.formation.jsf.webService.HelloService{
    public com.m2i.formation.jsf.managedBeans.BookTO getById(int id) throws java.rmi.RemoteException {
    	BookTO b = new BookTO();
    	Media m = SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getById(id);
		b.setId(id);
		b.setTitle(m.getTitle());
		b.setPrice(m.getPrice());
		b.setType(m.getCategory());
		return b;
    }

    public com.m2i.formation.jsf.managedBeans.BookTO getBook(int id, java.lang.String title, double price) throws java.rmi.RemoteException {
    	BookTO b = new BookTO();
		b.setId(id);
		b.setTitle(title);
		b.setPrice(price);
		b.setType(1);
		return b;
    }

    public java.lang.String getHello() throws java.rmi.RemoteException {
        return "Hello World";
    }

}
