package com.springboot.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex01Controller {
	
	@GetMapping("/ex01")
	public String method(@RequestParam("id") String userId, 
			@RequestParam("pw") String userPw,
			Model model) {
		model.addAttribute("data1", "@RequestParam 예제");
		model.addAttribute("data2", "id:"+  userId+"pw:" +userPw);
		return "pages/viewpage01";
	}

}
