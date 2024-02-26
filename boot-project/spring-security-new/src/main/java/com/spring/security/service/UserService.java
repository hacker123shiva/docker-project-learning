package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.dao.UserRepo;
import com.spring.security.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	// @Autowired
	// private BCryptPasswordEncoder encoder;
	//
	public User save(User user) {
		// user.setPassword( encoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		User userRes = userRepo.save(user);
		return userRes;
	}
}
