package com.knauff.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.knauff.model.User;
import com.knauff.repository.RoleRepository;
import com.knauff.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired 
	BCryptPasswordEncoder bCryptPassEncoder;
	
	@Override
	public void save(User user) {
		user.setPassword(bCryptPassEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepo.findAll()));
		userRepo.save(user);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
}
