package com.moghadam.pmMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.moghadam.pmMVC.model.Project;
import com.moghadam.pmMVC.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectSercive;
	
	@RequestMapping(method=RequestMethod.GET,value="/index")
	public String index() {
		
		ModelAndView mv=new ModelAndView("index");
		Project p = projectSercive.findAll().iterator().next();
		mv.addObject("project", p);
		return "index";
		
	}

}
