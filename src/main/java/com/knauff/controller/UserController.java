package com.knauff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.knauff.model.User;
import com.knauff.service.SecurityService;
import com.knauff.service.UserService;
import com.knauff.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userForm", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		userService.save(userForm);
		
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
		
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username or password is invalid.");
		}
			
		
		if (logout != null) {
			model.addAttribute("message", "You have logged out successfully!");
		}
		
		return "login";
	}
	
	@GetMapping({"/", "/home"})
	public String home(Model model) {
		return "home";
	}
}
