package com.springboot.controller.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exam03Controller {
	@GetMapping("/exam03")
	public String requestMethod(Model model) {
		model.addAttribute("data1", "Model 예제");
		model.addAttribute("data2", "웹요청은url은 /exam3이다");
		return "pages/view03";
	}
	

}
