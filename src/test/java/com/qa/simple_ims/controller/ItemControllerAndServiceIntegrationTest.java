package com.qa.simple_ims.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.simple_ims.model.Item;
import com.qa.simple_ims.service.ItemService;
import com.qa.simple_ims.service.ItemServiceImpl;

public class ItemControllerAndServiceIntegrationTest {

	private static ItemCrudController controller;
	private static List<Item> items = new ArrayList<Item>();
	
	@BeforeEach
	void setup() {
		items.removeAll(items);
		Item freddo = new Item("Freddo", "Chocolate", 0.50);
		Item doubleDecker = new Item("Double Decker", "Chocolate", 0.55);
		freddo.setId(1);
		doubleDecker.setId(2);
		
		items.add(freddo);
		items.add(doubleDecker);
		
		controller = new ItemController(new ItemServiceImpl(items));
	}
	
	@Test
	void createItemTest() {
		Item item = new Item("Chuck Norris Doll", "Dolls", 53.99);
		item.setId(3);
		
		controller.createItem(item);
		Item storedItem = controller.getItemById(item.getId());
		
		assertEquals(storedItem, item);
	}
}
