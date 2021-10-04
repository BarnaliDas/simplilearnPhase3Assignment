package com.simplilearn.p3.SportyShoes.service;

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

import com.simplilearn.p3.SportyShoes.model.Role;
import com.simplilearn.p3.SportyShoes.model.User;
import com.simplilearn.p3.SportyShoes.repository.UserDao;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	 @Autowired
	    private UserDao userRepository;

	    @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
	        }

	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	    }

}
