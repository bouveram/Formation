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
		authorRepo.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		Author a = authorRepo.getById(3);
		a.setFirstName("Frederic");
		a.setLastName("François");
		authorRepo.save(a);
		
		MainService service = new MainService();
		service.addAuthorToMedia(a, 2);
		MediaRepository mediaRepo = new MediaRepository();
		mediaRepo.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		assertSame(a.getFirstName(), mediaRepo.getById(2).getAuthors().get(mediaRepo.getById(2).getAuthors().size()-1).getFirstName());
	}

}
