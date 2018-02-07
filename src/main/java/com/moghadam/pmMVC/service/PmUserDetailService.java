package com.moghadam.pmMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.moghadam.pmMVC.model.User;

public class PmUserDetailService implements UserDetailsService {

	@Autowired
	UserService userService;
	
	
	
	public UserDetails loadUserByUsername(String useranme) throws UsernameNotFoundException {

		User user=userService.findByUsername(useranme);
		if(useranme==null)
			throw new UsernameNotFoundException(useranme); 

		return user;
	}

}
