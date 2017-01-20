package com.lab.waa.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import com.lab.waa.model.Users;

@Repository
public class UserRepositoryImpl implements UserRepository {

	HashMap<String, String> hmap = new HashMap<String, String>();

	public UserRepositoryImpl() {

		hmap.put("admin", "test123");
		hmap.put("hari", "1234");
	}

	/*
	 * public UserRepositoryImpl() { Users user1 = new Users();
	 * user1.setUserName("admin"); user1.setPassword("test123");
	 * user1.setRememberMe(false);
	 * 
	 * userList.add(user1); }
	 */

	@Override
	public boolean authenticateUser(Users user) {

		 if(hmap.containsKey(user.getUserName()))
		 {
			 if(hmap.get(user.getUserName()).equals(user.getPassword())){
				 return true;			 
			 }
		 }
		 
		 
			 return false; 
	}

}
