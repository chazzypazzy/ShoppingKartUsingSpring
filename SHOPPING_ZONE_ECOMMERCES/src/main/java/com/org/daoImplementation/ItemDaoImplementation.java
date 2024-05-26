package com.org.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ItemDao;
import com.org.dto.Item;
import com.org.dto.User;

@Component
public class ItemDaoImplementation implements ItemDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopping");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	public void SaveAndUpdateItems(Item item) {
		et.begin();
		em.merge(item);
		et.commit();
	}

	@Override
	public Item FetchItemsById(int id) {
		return em.find(Item.class, id);
	}

	@Override
	public List<Item> FetchAllItems() {
		Query query = em.createQuery("SELECT i FROM Item i");
		List<Item> list = query.getResultList();
		if (list != null) {
			return list;
		}
		return null;
	}

	@Override
	public void RemoveItemById(int id) 
	{
		Item item = em.find(Item.class, id);
		User user = item.getUser();
		List<Item> items = user.getItems();
		items.remove(item);
		et.begin();
		em.remove(item);
		et.commit();
	}

}
