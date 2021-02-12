package com.qa.simple_ims;

import java.util.ArrayList;
import java.util.List;

import com.qa.simple_ims.controller.ItemController;
import com.qa.simple_ims.controller.ItemCrud;
import com.qa.simple_ims.model.Item;
import com.qa.simple_ims.service.ItemService;
import com.qa.simple_ims.service.ItemServiceImpl;

public class Runner {

	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();
		ItemService service = new ItemServiceImpl(items);
		ItemCrud controller = new ItemController(service);
		
		controller.createItem(new Item("Freddo", "Chocolate", 0.50));
		controller.createItem(new Item("Double Decker", "Chocolate", 0.55));
		
		System.out.println(controller.getItemById(1));
		System.out.println(controller.getItemById(2));
	}

}
