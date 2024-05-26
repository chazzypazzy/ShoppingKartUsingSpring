package com.org.dao;

import java.util.List;

import com.org.dto.Item;

public interface ItemDao 
{
	void SaveAndUpdateItems(Item item);
	Item FetchItemsById(int id);
	List<Item> FetchAllItems();
	void RemoveItemById(int id);
}
