package com.springboot.controller.param;

import com.springboot.Jwboot1Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Ex02Controller {

    private final Jwboot1Application jwboot1Application;

    Ex02Controller(Jwboot1Application jwboot1Application) {
        this.jwboot1Application = jwboot1Application;
    }
	@GetMapping("/boards/{id}")
	public String method1(@PathVariable("id")Long id,
			Model model)
	{
		model.addAttribute("data1", "@PathVariable 예제");
		model.addAttribute("data2", "계시글번호"+id);
		return "pages/viewPage02";
	}

}
