package com.org.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ProductDao;
import com.org.dto.Product;
import com.org.dto.Seller;

@Component
public class ProductDaoImplementation implements ProductDao
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopping");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	@Override
	public void SaveAndUpdateProduct(Product product) 
	{
		
		et.begin();
		em.merge(product);
		et.commit();
	}
	@Override
	public Product FetchProductById(int id) {
		
		return em.find(Product.class, id);
	}
	@Override
	public List<Product> FetchAllProducts() {
		Query query = em.createQuery("SELECT p FROM Product p");
		List<Product> list = query.getResultList();
		if(list != null)
		{
			return list;
		}
		return null;
	}

	@Override
	public void deleteProduct(int id) {
		
		Product product = em.find(Product.class, id);
		Seller seller = product.getSeller();
		List<Product> products = seller.getProducts();
		products.remove(product);
		
		et.begin();
		em.remove(product);
		et.commit();
	}

}
