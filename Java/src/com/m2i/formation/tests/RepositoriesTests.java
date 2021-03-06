package com.m2i.formation.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.*;

import com.m2i.formation.media.entities.Book;
import com.m2i.formation.media.repositories.BookDbRepository;
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
	
	@Test
	public void getUriTest() throws IOException {
		BookRepository fichier = new BookRepository();
	    fichier.setUri("C:\\Users\\adminlocal\\git\\Java\\Livres.csv");
		String uri = fichier.getUri();
		Assert.assertNotNull(uri);
		Assert.assertEquals("C:\\Users\\adminlocal\\git\\Java\\Livres.csv", uri);
	}
	
	@Ignore
	@Test
	public void insertBookTest() throws IOException {
		Book b = new Book();
		b.setTitle("livre ajout�");
		b.setPrice(9.99);
		BookRepository fichier = new BookRepository();
		int nbBook = fichier.getAll().size();
	    fichier.insert(b);
		Assert.assertEquals(nbBook+1, fichier.getAll().size());
	}
	
	@Test
	public void getAllWithDb() throws SQLException, IOException, ClassNotFoundException {
		BookDbRepository repo = new BookDbRepository();
		List<Book> l = repo.getAll();
		Assert.assertTrue(l.size() > 0);
	}
	
	@Test
	public void getByIdWithDb() throws SQLException, IOException, ClassNotFoundException {
		BookDbRepository repo = new BookDbRepository();
		Book b = repo.getById(2);
		Assert.assertEquals("l'�tranger",b.getTitle());
	}

}
