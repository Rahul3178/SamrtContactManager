package com.smart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

@Controller
public class UserRegistrationController {

	// User Registration controller

	/* here we do auto wiring of dao class/ service class */
	@Autowired
	private UserRepository userRepository;

	/*
	 * here we are doing Bcrypt Passoword encryption encoding with the help of
	 * autowiring and we declare this bean in myconfig file which implementing
	 * WebSecurtiyConfigAdapter
	 * 
	 * 
	 * 
	 */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/do_register")
	public String do_register(@ModelAttribute("user") @Valid User user, BindingResult bresult,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {

		/* inside try catch to throw an error */

		try {

			System.out.println("resulkt:" + bresult);
			if (bresult.hasErrors()) {
				System.out.println("Error: " + bresult.toString());
				model.addAttribute("user", user);
				return "signup";

			}

			if (!agreement) {
				System.out.println("Please accept terms and conditions");
				throw new Exception("Please accept terms and conditions");
			}

			user.setUserRole("ROLE_USER");
			user.setStatus(true);
			user.setUserImage("default.png");
			// BCrypt password encoder to encode password
			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

			// save in database

			User result = this.userRepository.save(user);
			
			model.addAttribute("user", user);// this provide data agin in input fields
			
			System.out.println(result);
			System.out.println("Agrement value: " + agreement);
			session.setAttribute("message", new Message("Successfully registered!!!", "alert-success"));

			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something Went Wrong!!!" + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}
}
