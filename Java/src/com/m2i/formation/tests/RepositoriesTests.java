package com.m2i.formation.tests;

import java.io.IOException;
import java.util.List;

import org.junit.*;

import com.m2i.formation.media.entities.Book;
import com.m2i.formation.media.repositories.BookRepository;

public class RepositoriesTests {
	
	@Test
	public void getAllTest() throws IOException {
		BookRepository fichier = new BookRepository();
	    fichier.setUri("C:\\Users\\adminlocal\\git\\Java\\Livres.csv");
		List<Book> liste = fichier.getAll();
		Assert.assertEquals(3, liste.size());
		Assert.assertEquals(2, liste.get(0).getNbPage());
		
	}
	
	@Test
	public void getByIdTest() throws IOException {
		BookRepository fichier = new BookRepository();
	    fichier.setUri("C:\\Users\\adminlocal\\git\\Java\\Livres.csv");
		Book b = fichier.getById(9);
		Assert.assertEquals(4.5, b.getPrice(),0.0001);
		Assert.assertNotEquals("Je suis un goeland", b.getTitle());
	}
	
	@Test
	public void getByPriceTest() throws IOException {
		BookRepository fichier = new BookRepository();
	    fichier.setUri("C:\\Users\\adminlocal\\git\\Java\\Livres.csv");
		List<Book> liste = fichier.getByPrice(50.5);
		Assert.assertEquals(2, liste.size());
		Assert.assertEquals(50.4, liste.get(0).getPrice(),0.001);
	}
	
	@Test
	public void getByTitleTest() throws IOException {
		BookRepository fichier = new BookRepository();
	    fichier.setUri("C:\\Users\\adminlocal\\git\\Java\\Livres.csv");
		List<Book> liste = fichier.getByTitle("nono");
		Assert.assertEquals(1, liste.size());
		Assert.assertEquals(67, liste.get(0).getId());
	}

}
