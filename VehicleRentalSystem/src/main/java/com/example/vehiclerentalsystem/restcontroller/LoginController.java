package com.example.vehiclerentalsystem.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.vehiclerentalsystem.entity.Login;
import com.example.vehiclerentalsystem.serviceimpl.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService loginservice;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user",new Login());
		return mav;
		
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") Login user) {
		Login oauthUser = loginservice.login(user.getUsername(),user.getPassword());
		
		logger.info("User logging in : "+oauthUser);
		if(oauthUser!=null)
		{
			return "redirect:/";
		}
		else {
			return "redirect:/login";
		}
		
	}
	@RequestMapping(value = {"/logout"},method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request,HttpServletResponse response) {
		return "redirect:/login";
	}

}
