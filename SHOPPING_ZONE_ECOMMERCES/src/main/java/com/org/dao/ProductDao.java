package com.org.dao;

import java.util.List;

import com.org.dto.Product;

public interface ProductDao 
{
	void SaveAndUpdateProduct(Product product);
	
	Product FetchProductById(int id);
	
	List<Product> FetchAllProducts();
	
	void deleteProduct(int id);
	
}
