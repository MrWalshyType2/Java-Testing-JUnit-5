package com.qa.simple_ims.controller;

import com.qa.simple_ims.model.Item;
import com.qa.simple_ims.service.ItemNotFoundException;
import com.qa.simple_ims.service.ItemService;

public class ItemController implements ItemCrudController {
	
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	public void createItem(Item item) {
		itemService.createItem(item);
	}

	public Item getItemById(int id) {
		try {
			return itemService.getItemById(id);
		} catch (ItemNotFoundException e) {
			return null;
		}
	}

	public Item updateItem(Item item) {
		try {
			return itemService.updateItem(item);
		} catch (ItemNotFoundException e) {
			return null;
		}
	}

	public boolean deleteItem(int id) {
		try {
			itemService.deleteItem(id);
			return true;
		} catch (ItemNotFoundException e) {
			return false;
		}
	}

}
