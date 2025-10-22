package com.springboot.controller.exam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/exam02")
@RestController

public class Exam02Controller {
	
	@GetMapping("/rest")
	public String requestMethod() {
		return "<h2>@RestController  예제입니다</h2>";
	}

}
