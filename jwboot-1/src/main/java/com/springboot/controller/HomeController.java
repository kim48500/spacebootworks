package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping ("/")
	public String home() {
		return "home"; //home
	}
	@GetMapping("/time")
	public String timeMethod() {
		return "pages/time";
	}

}
