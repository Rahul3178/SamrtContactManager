package com.smart.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.entities.User;

public class CustomUserDetails implements UserDetails {

	// here we declare user variable to get user details like password, username

	private User user;

	// here we call CustomUserDetails method and pass user as parameter to set
	// things

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// here we provide policier or roles of user or system like system admin or
		// normal user
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getUserRole());
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {

		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		// bcz here we use email as user name
		return user.getUserEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// now make everything true
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// now make everything true
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// now make everything true
		return true;
	}

	@Override
	public boolean isEnabled() {
		// now make everything true
		return true;
	}

}
