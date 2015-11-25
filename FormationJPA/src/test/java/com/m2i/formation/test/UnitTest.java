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
	
	@Test
	public void insertMediaTest() {
				
		EntityManager em = EMFSingleton.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Query tq = em.createQuery("select count(m) from Media m");
		assertEquals(3l, tq.getSingleResult());
		
		//Creation et Commit du média
		Media med = new Media();
		med.setId_Publisher(2);
		med.setPrice(50);
		med.setTitle("Mon nouveau livre");
		med.setType(0);
		tx.begin();
		em.persist(med);
		tx.commit();
		
		assertEquals(4l, tq.getSingleResult());
		
		//Modification du titre
		med.setTitle("Change Titre");
		tx.begin();
		em.persist(med);
		tx.commit();
		tq = em.createQuery("select m.title from Media m where m.id = " + med.getId());
		assertEquals("Change Titre", tq.getSingleResult());
		
		//select medias where is price under 25
		tq = em.createQuery("select m from Media m where m.price < 25");
		assertEquals(3, tq.getResultList().size());
		
		//Delete previously added row
		tx.begin();
		em.remove(med);
		tx.commit();
		
		//BD is not changed
		tq = em.createQuery("select count(m) from Media m");
		assertEquals(3l, tq.getSingleResult());
		
	}

}
