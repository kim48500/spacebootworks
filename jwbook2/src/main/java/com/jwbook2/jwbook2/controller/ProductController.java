package com.jwbook2.jwbook2.controller;

import org.springframework.aot.hint.BindingReflectionHintsRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jwbook2.jwbook2.dto.Product;

import jakarta.validation.Valid;

@RequestMapping("/valid01")
@Controller
public class ProductController {

	@GetMapping
	public String showForm(@ModelAttribute Product product) {
		//product 모델을 보냄
		return "validation/viewPage01";
	}
	
	@PostMapping
	public String addProduct(@Valid Product product,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { 
			//에러가 있으면 상품 등록 폼 이동
			return "validation/viewPage01";
		}
		//정상이면 홈으로 이동
		return "redirect:/";
	}
}