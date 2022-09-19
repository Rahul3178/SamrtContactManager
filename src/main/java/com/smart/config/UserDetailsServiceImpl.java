package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	// here we Autowired UserRepository object to fetch data from db
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*
		 * here we have to call our custom method who fetch user information from db
		 * based on Email
		 */
		
		User user = userRepository.getUserByUserName(username);
		
		/* giving validation */
		if(user==null)
		{
			throw new UsernameNotFoundException("User is not Registered yet");
		}
		
		/*
		 * now provide this user which we get from db to CustomUserDetails class where
		 * we fetch user details like user email password for login perspective.
		 * for that we return CustomUserDetails object 
		 */
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);

		return customUserDetails;
	}

}
