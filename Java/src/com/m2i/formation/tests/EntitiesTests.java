package com.m2i.formation.tests;

import org.junit.*;

import com.m2i.formation.media.entities.*;

public class EntitiesTests {

	@Test
	public void test() {
		Book b = new Book();
		b.setId(5);
		Assert.assertEquals(5, b.getId());
		
	}
	
	@Test
	public void vatPriceTest() {
		Media m = new Book();
		m.setPrice(10);
		Assert.assertEquals(10.5, m.getVATPrice(),0.001);
		
	}

}
