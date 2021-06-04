package com.knauff.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knauff.model.Role;
import com.knauff.model.User;
import com.knauff.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		User user = userRepo.findByUsername(username);
		
		if (user == null) throw new UsernameNotFoundException(username);
		
		Set<GrantedAuthority> grantedAuths = new HashSet<>();
		for (Role role : user.getRoles()) {
			
			grantedAuths.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(), grantedAuths);
	}
}

// implement streams
// log4j?