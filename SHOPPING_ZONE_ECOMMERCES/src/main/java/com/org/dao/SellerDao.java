package com.org.dao;

import com.org.dto.Seller;

public interface SellerDao 
{
	void SaveAndUpdateSeller(Seller seller);
	Seller FetchSellerByEmailAndPassword(String email, String password);
	Seller FetchSellerById(int id);
	Seller FetchSellerByEmail(String email);
	String verificationSellerOTP(String email);
}
