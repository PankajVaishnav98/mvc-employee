package com.mindtree.learning.mvcemployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.learning.collegemvc.domain.College;

@Controller
@RequestMapping("/")
public class WelcomeController {

	//CHECKING WITH MVN LOCAL REPOSITORY BY ADDING LOCAL PROJECT INTO DEPENDENCY
	//College college  = new College();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String callHome() {
	
		return "index";
	
	}
	
}
