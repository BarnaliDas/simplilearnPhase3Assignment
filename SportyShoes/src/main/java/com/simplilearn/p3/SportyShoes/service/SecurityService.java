package com.simplilearn.p3.SportyShoes.service;

public interface SecurityService {
	String findLoggedInUsername();

    void autologin(String username, String password);
}
