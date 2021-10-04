package com.simplilearn.p3.SportyShoes.service;

import com.simplilearn.p3.SportyShoes.model.User;

public interface UserService {
	 User findByUsername(String username);
}
