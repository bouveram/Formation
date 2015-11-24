package com.m2i.formation.test;

import static org.junit.Assert.*;

import javax.persistence.*;

import org.junit.*;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.repositories.EMFSingleton;

public class UnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void entityManagerTest() {
		EntityManager em = EMFSingleton.getEmf().createEntityManager();
		assertNotNull(em);
	}
	
	@Test
	public void findEntitiesTest() {
		EntityManager em = EMFSingleton.getEmf().createEntityManager();
		Media m = em.find(Media.class, 1);
		assertNotNull(m);
		assertEquals("Le lievre et la tortue", m.getTitle());
	}

}
