package com.lab.waa.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.waa.model.Users;
import com.lab.waa.repository.UserRepository;


@Service
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public boolean authenticateUser(Users user) {
		
		return userRepository.authenticateUser(user);
	}

}
