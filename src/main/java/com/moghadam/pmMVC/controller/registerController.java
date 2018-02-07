package com.moghadam.pmMVC.controller;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.moghadam.pmMVC.model.Project;
import com.moghadam.pmMVC.model.User;
import com.moghadam.pmMVC.service.UserService;

@Controller
@RequestMapping(method=RequestMethod.POST,value="/users")
public class registerController {

	@Autowired
    UserService userService;
	
	@Autowired
	MailClient mailClient;
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public ModelAndView registerUser(@ModelAttribute("user") User userModel, 
            BindingResult result, WebRequest request, Errors errors) {
		
		// behatar ast in kar dar laye controller anjam shavad
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String passwd = encoder.encode(userModel.getPasswd());
		userModel.setPasswd(passwd);
		
		
		
		userService.save(userModel);
		Map<String, Object> maps=new HashedMap();
		maps.put("username", userModel.getUsername());
		maps.put("code", userModel.getId());
		mailClient.send("moghadam.1153@gmail.com", userModel.getEmail(), "Verify Account", "com/moghadam/pmMVC/controller/register.vm", maps, new UncaughtExceptionHandler() {
            
            public void uncaughtException(Thread t, Throwable e)
            {
                System.out.println("email is not sent ");
            }
        });
		ModelAndView mv=new ModelAndView("thankyou");
		
		return mv;
		
	}
}
