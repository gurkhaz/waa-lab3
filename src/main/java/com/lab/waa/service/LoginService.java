package com.lab.waa.service;

import org.apache.catalina.User;

import com.lab.waa.model.Users;

public interface LoginService {
	
	public boolean authenticateUser(Users user);

}
