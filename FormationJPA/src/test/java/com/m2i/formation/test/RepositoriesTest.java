package com.m2i.formation.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.repositories.EMFSingleton;
import com.m2i.formation.repositories.MediaRepository;

public class RepositoriesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

}
