package com.lab.waa.repository;

import org.apache.catalina.User;

import com.lab.waa.model.Users;

public interface UserRepository {
	
	
	public boolean authenticateUser(Users user);

}
