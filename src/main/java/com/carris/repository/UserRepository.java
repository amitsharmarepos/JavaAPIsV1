package com.carris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cpm.carris.model.User;



public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndPassword(String username,String password);
}
