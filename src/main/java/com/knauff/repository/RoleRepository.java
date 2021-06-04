package com.knauff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knauff.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
