package com.knauff.service;

import com.knauff.model.User;

public interface UserService {

	void save(User user);
	
	User findByUsername(String username);
}
