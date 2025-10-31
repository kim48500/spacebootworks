package com.Test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springboot.dto.MemberDTO;
import com.springboot.service.MemberService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor  //생성자 주입
@Slf4j
@RequestMapping("/members")
@Controller
public class MemberController {
	//서비스 인스턴스 생성
		private MemberService service;

	    

		//회원 가입 페이지
		@GetMapping("/singup")
		public String joinForm(MemberDTO memberDTO) {
			return "member/singup";
		}
		
		//회원 가입 처리
		@PostMapping("/singup")
		public String join(@Valid MemberDTO memberDTO,
			BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return "member/signup";
			}
			log.info("member: " + memberDTO);
			service.save(memberDTO);  //서비스에 있는 save() 호출
			return "redirect:/home";
		}

		}
		
