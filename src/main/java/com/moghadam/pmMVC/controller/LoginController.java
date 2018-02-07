package com.moghadam.pmMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.moghadam.pmMVC.model.Project;
import com.moghadam.pmMVC.model.User;
import com.moghadam.pmMVC.service.UserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
    UserService userService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mv=new ModelAndView("login");
		User user=new User();
		mv.addObject("user", user);
		return mv;
		
	}
	
	
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView post(@ModelAttribute("user") User user) {
	
		ModelAndView mv=new ModelAndView("activated");
		mv.addObject("user", userService.findById(userId));
		return mv;
		
	}
	*/
}
