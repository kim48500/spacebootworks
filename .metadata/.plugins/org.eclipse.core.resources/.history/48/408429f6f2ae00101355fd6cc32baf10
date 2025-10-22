package com.springboot.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.dto.User;

@Controller

public class Ex03Controller {
@GetMapping("/userForm")
public String formPage() {
	return "pages/userForm";
}
@PostMapping("/login")
public String resultPage(@ModelAttribute User user,
		Model model) {
	System.out.println("user:"+ user);
	model.addAttribute("data1", "@moelattribute 예제");
	model.addAttribute("data2" ,
			"id" + user.getId()+ "<br>pw"+user.getPw());
	
	return "pages/viewPage03";
}
//문자열 보내기
@GetMapping("/exJson")
public @ResponseBody User httpGet() {
	User user = User.builder()
			.id("today")
		    .pw("12345")
		    .build();
	return user;
}
}
