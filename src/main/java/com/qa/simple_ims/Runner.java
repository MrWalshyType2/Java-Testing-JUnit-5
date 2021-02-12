package com.qa.simple_ims;

import java.util.ArrayList;
import java.util.List;

import com.qa.simple_ims.controller.ItemController;
import com.qa.simple_ims.controller.ItemCrudController;
import com.qa.simple_ims.model.Item;
import com.qa.simple_ims.service.ItemService;
import com.qa.simple_ims.service.ItemServiceImpl;

public class Runner {

	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();
		ItemService service = new ItemServiceImpl(items);
		ItemCrudController controller = new ItemController(service);
		
		// Create two new items
		controller.createItem(new Item("Freddo", "Chocolate", 0.50));
		controller.createItem(new Item("Double Decker", "Chocolate", 0.55));
		
		// Get item by its id
		Item item1InDb = controller.getItemById(1);
		System.out.println(item1InDb);
		
		// Update item
		item1InDb.setPrice(0.35);
		controller.updateItem(item1InDb);
		System.out.println(controller.getItemById(1));
	}

}
