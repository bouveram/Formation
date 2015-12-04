package com.m2i.formation.jsf.serviceREST;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.m2i.formation.jsf.managedBeans.*;
import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.SpringSingleton;
import com.m2i.formation.media.services.MainService;

@Path("/item")
public class GenericService {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String doHello() {
		return "Hello";
	}
	
	@GET
	@Path("/hello/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String doHello(@PathParam("param") String param) {
		return "Hello " + param;
	}
	
	@GET
	@Path("/booksample")
	@Produces(MediaType.APPLICATION_JSON)
	public BookTO getBookSample() {
		BookTO b = new BookTO();
		b.setId(1);
		b.setPrice(10.26);
		b.setTitle("Mon Jolie Livre");
		b.setType(1);
		return b;
	}
	
	@GET
	@Path("/book/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookTO> getAllBooks() {
		List<BookTO> books = new ArrayList<BookTO>();
		BookTO b = null;
		for(Media m:SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getAll()){
			b = new BookTO();
			b.setTitle(m.getTitle());
			b.setId(m.getId());
			b.setPrice(m.getPrice());
			b.setType(m.getCategory());
			b.setPriceVAT();
			books.add(b);
		}
		return books;
	}
	
	@GET
	@Path("/book/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookTO getBookById(@PathParam("bookId") int id) {
		BookTO b = new BookTO();
    	Media m = SpringSingleton.getXBF().getBean("mainService",MainService.class).getMediaRepository().getById(id);
		b.setId(id);
		b.setTitle(m.getTitle());
		b.setPrice(m.getPrice());
		b.setType(m.getCategory());
		b.setPriceVAT();
		return b;
	}
	
	@GET
	@Path("/phone/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PhoneBean> getAllPhone() {
		PhoneBean p1 = new PhoneBean();
		PhoneBean p2 = new PhoneBean();
		PhoneBean p3 = new PhoneBean();
		PhoneBean p4 = new PhoneBean();
    	List<PhoneBean> phoneList = new ArrayList<PhoneBean>();
    	p1.setAge(1);
    	p1.setId("nexus-5");
    	p1.setImageUrl("http://techbeasts.com/wp-content/uploads/2015/03/Google-Nexus-5-Photo1.jpg");
    	p1.setName("Google Nexus 5");
    	p1.setSnippet("Petit texte de presentation de ce telephone");
    	phoneList.add(p1);
    	p2.setAge(2);
    	p2.setId("iphone-6");
    	p2.setImageUrl("http://gadgets.ndtv.com/apple-iphone-6-plus-1974");
    	p2.setName("Apple Iphone 6");
    	p2.setSnippet("Petit texte de presentation de cette pomme");
    	phoneList.add(p2);
    	p3.setAge(1);
    	p3.setId("galaxy-s6");
    	p3.setImageUrl("http://www.samsung.com/ca_fr/consumer-images/product/mobile-phones/2015/SM-G920WZWABMC/features/SM-G920WZWABMC-403979-0.jpg");
    	p3.setName("Samsung Galaxy S6");
    	p3.setSnippet("Telephone concurent de la pomme !");
    	phoneList.add(p3);
    	p3.setAge(2);
    	p4.setId("xperia-z3-compact");
    	p4.setImageUrl("http://img.clubic.com/07606839-photo-iphone6-2.jpg");
    	p4.setName("Sony Xperia Z3 Compact");
    	p4.setSnippet("Ce telephone est le meilleur compromis qui existe au monde !");
    	phoneList.add(p4);
		return phoneList;
	}
}
