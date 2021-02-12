package com.qa.simple_ims.controller;

import com.qa.simple_ims.model.Item;

public interface ItemCrud {

	public void createItem(Item item);
	public Item getItemById(int id);
	public Item updateItem(Item item);
	public boolean deleteItem(int id);
}
