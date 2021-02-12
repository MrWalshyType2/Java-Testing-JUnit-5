package com.qa.simple_ims.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.qa.simple_ims.model.Item;

public class ItemServiceImplUnitTest {

	private static ItemService service;
	private static List<Item> items;
	
	@BeforeAll
	static void init() {
		items = new ArrayList<Item>();
		service = new ItemServiceImpl(items);
	}
	
	@BeforeEach
	void setup() {
		items.removeAll(items);
		Item freddo = new Item("Freddo", "Chocolate", 0.50);
		Item doubleDecker = new Item("Double Decker", "Chocolate", 0.55);
		freddo.setId(1);
		doubleDecker.setId(2);
		
		items.add(freddo);
		items.add(doubleDecker);
		
		service = new ItemServiceImpl(items);
	}
	
	@Test
	public void createItemSuccessTest() throws ItemNotFoundException {
		Item itemToCreate = new Item("Worms", "Bait", 1.99);
		// Always has an ID of 3 when created as we reset the items list before every test
		service.createItem(itemToCreate); 
		
		Item itemCreated = service.getItemById(3);
		assertEquals(itemToCreate.getName(), itemCreated.getName());
		assertEquals(itemToCreate.getCategory(), itemCreated.getCategory());
		assertEquals(itemToCreate.getPrice(), itemCreated.getPrice());
	}
}
