package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.User;
import com.spring.security.service.UserService;
 

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User user){
		User userRes=userService.save(user);
		return ResponseEntity.ok(userRes); 
		
	}
}
