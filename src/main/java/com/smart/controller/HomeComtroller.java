package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@Controller
public class HomeComtroller {
	// here we do repository autowired
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - Smart Contract Manager");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - Smart Contract Manager");
		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Signup - Smart Contract Manager");
		// we use this blank attribute to thow error while server side rendring
		model.addAttribute("user", new User());
		/* now we pass those valus to signup page */
		
		return "signup";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Login - Smart Contract Manager");
		return "login";
	}
	
	
}
