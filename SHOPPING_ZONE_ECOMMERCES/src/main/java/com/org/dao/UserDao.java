package com.org.dao;

import com.org.dto.User;

public interface UserDao 
{
	void SaveAndUpdateUser(User user);
	User FetchUserByEmailAndPassword(String email,String password);
	User FetchUserByID(int id);
	User FetchUserByEmail(String email);
	String verificationUserOTP(String email);
}
