package formationJPA.test;

import static org.junit.Assert.*;

import javax.persistence.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void entityManagerTest() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationJPA");
		assertNotNull(emf);
		EntityManager em = emf.createEntityManager();
		assertNotNull(em);
	}

}
