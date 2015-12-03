package com.m2i.formation.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.junit.BeforeClass;
import org.junit.Test;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.repositories.*;

public class RepositoriesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void entityManagerTest() {
		MediaRepository repo = new MediaRepository();
		repo.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		assertNotNull(repo.getEntityManager());
	}
	
	@Test
	public void transactionTest() {
		MediaRepository repo = new MediaRepository();
		repo.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		assertNotNull(repo.getTransaction());
	}
	
	@Test
	public void saveUpdateRemoveTest() {
		MediaRepository repo = new MediaRepository();
		repo.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		
		Publisher p = repo.getEntityManager().find(Publisher.class, 1);
		Media m = new Media();
		m.setPrice(10);
		m.setPublisher(p);
		m.setTitle("test");
		m.setCategory(0);
		
		repo.save(m);
		repo.commit();
		assertEquals(4, repo.getAll().size());
		
		m.setPrice(25);
		repo.save(m);
		repo.commit();
		assertEquals(2, repo.getByPrice(15).size());
		
		repo.remove(m);
		repo.commit();
		assertEquals(3, repo.getAll().size());
	}
	
	@Test
	public void getAllMediaTest() {
		MediaRepository repo = new MediaRepository();
		repo.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		List<Media> list = repo.getAll();
		assertEquals(3, list.size());
	}
	
	@Test
	public void getByPriceMediaTest() {
		MediaRepository repo = new MediaRepository();
		repo.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		List<Media> list = repo.getByPrice(10);
		assertEquals(2, list.size());
	}
	
	
	@Test
	public void springTest() {
		Media med = (Media) SpringSingleton.getXBF().getBean("media");
		assertNotNull(med);
	}
	
	@Test
	public void springTest2() {
		@SuppressWarnings("unchecked")
		IRepository<Media> medRep1 = (IRepository<Media>)SpringSingleton.getXBF().getBean("mediaRepository");
		MediaRepository medRep2 = SpringSingleton.getXBF().getBean("mediaRepository",MediaRepository.class);
		assertNotEquals(medRep1, medRep2);
	}

}
