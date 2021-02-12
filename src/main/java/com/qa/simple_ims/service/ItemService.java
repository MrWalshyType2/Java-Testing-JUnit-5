package com.qa.simple_ims.service;

import com.qa.simple_ims.model.Item;

public interface ItemService {

	public void createItem(Item item);
	public Item getItemById(int id) throws ItemNotFoundException;
	public Item updateItem(Item item) throws ItemNotFoundException;
	public void deleteItem(int id) throws ItemNotFoundException;
}
