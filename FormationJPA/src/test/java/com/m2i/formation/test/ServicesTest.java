package com.m2i.formation.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.repositories.*;
import com.m2i.formation.media.services.*;

public class ServicesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void mainServiceTest() throws ServiceException {
		
		AuthorRepository authorRepo = new AuthorRepository();
		Author a = authorRepo.getById(3);
		a.setFirstName("Frederic");
		a.setLastName("François");
		authorRepo.save(a);
		
		MainService service = SpringSingleton.getXBF().getBean("mainService",MainService.class);
		service.addAuthorToMedia(a, 2);
		MediaRepository mediaRepo = new MediaRepository();
		assertSame(a.getFirstName(), mediaRepo.getById(2).getAuthors().get(mediaRepo.getById(2).getAuthors().size()-1).getFirstName());
	}
	
	@Test
	public void springIntantiationTest() throws ServiceException {
		
		MainService service = SpringSingleton.getXBF().getBean("mainService",MainService.class);
		assertNotNull(service);
		assertNotNull(service.getMediaRepository().getEntityManager());
		assertNotNull(service.getAuthorRepository());
		assertNotNull(service.getMediaRepository());
		
	}

}
