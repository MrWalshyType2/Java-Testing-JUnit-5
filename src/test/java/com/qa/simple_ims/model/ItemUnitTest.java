package com.qa.simple_ims.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ItemUnitTest {

	@Test
	public void itemDefaultConstructorTest() {
		Item item = new Item();
		
		assertNotNull(item);
	}
	
	@Test
	public void itemAllArgsConstructorTest() {
		Item item = new Item("Freddo", "Chocolate", 0.50);
		
		assertNotNull(item);
		assertEquals("Chocolate", item.getCategory());
	}
}
