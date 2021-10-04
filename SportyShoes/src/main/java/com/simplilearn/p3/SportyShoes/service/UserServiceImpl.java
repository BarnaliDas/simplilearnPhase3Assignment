package com.simplilearn.p3.SportyShoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.simplilearn.p3.SportyShoes.model.User;
import com.simplilearn.p3.SportyShoes.repository.UserDao;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userRepository;
   
    

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
