package com.simplilearn.p3.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.p3.SportyShoes.model.User;


public interface UserDao extends JpaRepository<User, Integer> {
	
	 User findByUsername(String username);
	

}
