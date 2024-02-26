package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.dao.UserRepo;
import com.spring.security.entity.User;
import com.spring.security.entity.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired 
	 private UserRepo userRepo;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 
	 User user=	userRepo.findByUserName(userName);
	 if(user==null) {
		 System.out.println("User 404");
		 throw new UsernameNotFoundException("user 404");
	 }
		return new UserPrincipal(user);
	}
	
	 
}
