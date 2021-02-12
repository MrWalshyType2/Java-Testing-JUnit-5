package com.qa.simple_ims.service;

import java.util.List;

import com.qa.simple_ims.model.Item;

public class ItemServiceImpl implements ItemService {
	
	private List<Item> items;
	
	public ItemServiceImpl(List<Item> items) {
		this.items = items;
	}

	public void createItem(Item item) {
		try {
			item.setId(getNewId());
			items.add(item);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Item getItemById(int id) throws ItemNotFoundException {
		for (int i = 0; i < items.size(); i++) {
			Item currentItem = items.get(i);
			if (currentItem.getId() == id) {
				return currentItem;
			}
		}
		throw new ItemNotFoundException();
	}

	public Item updateItem(Item item) throws ItemNotFoundException {
		Item itemInStorage = getItemById(item.getId());
		
		itemInStorage.setName(item.getName());
		itemInStorage.setCategory(item.getCategory());
		itemInStorage.setPrice(item.getPrice());
		
		Item returnable = new Item(item.getName(),
								   item.getCategory(),
								   item.getPrice());
		returnable.setId(itemInStorage.getId());
		
		return returnable;
	}

	public void deleteItem(int id) throws ItemNotFoundException {
		boolean isDeleted = false;
		for (int i = 0; i <= items.size(); i++) {
			Item currentItem = items.get(i);
			if (currentItem.getId() == id) {
				items.remove(i);
				isDeleted = true;
			}
		}
		
		if (isDeleted == false) {
			throw new ItemNotFoundException();
		}
	}

	private int getNewId() {
		int id = 0;
		int highestId = 0;
		
		for (int i = 0; i < items.size(); i++) {
			int currentItemId = items.get(i)
									 .getId();
			if (currentItemId > highestId) {
				highestId = currentItemId;
			}
		}
		id = highestId + 1;
		return id;
	}
}
