package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/index")
	public String user_dashboard(Model model, Principal pr) {
		model.addAttribute("title", "User Dashboard");
		
		String username = pr.getName();
		/*
		 * with the help of this Principle we get user name as Email and with the help
		 * of email we get other details of user form db
		 */
		
		System.out.println("user dashboard");
		System.out.println("principle:" + username);
		User user = this.userRepository.getUserByUserName(username);
		model.addAttribute("user", user); // now we send value to our html page
		System.out.println(user);
		return "normal/userdashboard";
	}
}
