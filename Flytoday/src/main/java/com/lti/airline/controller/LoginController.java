package com.lti.airline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.lti.airline.model.Passenger;
import com.lti.airline.service.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lti.airline.model.Passenger;
import com.lti.airline.service.Service;

@Controller
@RequestMapping("/loginpass")
public class LoginController {
	@Autowired
	private Service service;
	
	@GetMapping("/loginPassenger")
	public String showFormForAdd(Model theModel) {
		Passenger thepassenger = new Passenger();
		theModel.addAttribute("passenger", thepassenger);
		return "login";
	}
	
	@RequestMapping(value = "/Passengerlogin",  method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView processLogin(@ModelAttribute Passenger thepassenger) 
	{
		Passenger pass = service.checkPassenger( thepassenger);
		ModelAndView model = null;
		if (pass == null) {
			model = new ModelAndView("login");
			model.addObject("error", "Invalid Username or Password");
		} 
		else 
		{
			model = new ModelAndView("welcome");
			model.addObject("pass", pass);
			//model.addObject("usr", usr.getEmail());
		}
		return model;
	}
}


