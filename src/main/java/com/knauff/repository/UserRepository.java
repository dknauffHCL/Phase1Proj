package com.knauff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knauff.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
