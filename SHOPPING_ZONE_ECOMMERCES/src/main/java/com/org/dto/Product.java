package com.org.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long price;
	private String category;
	private String description;
	private int stockLeft;
	private int stockSold;
	
	@ManyToOne(cascade = CascadeType.ALL) //Many products have one seller only
	@JoinColumn
	private Seller seller;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStockLeft() {
		return stockLeft;
	}
	public void setStockLeft(int stockLeft) {
		this.stockLeft = stockLeft;
	}
	public int getStockSold() {
		return stockSold;
	}
	public void setStockSold(int stockSold) {
		this.stockSold = stockSold;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
}
