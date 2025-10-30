package com.springboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springboot.dto.MemberDTO;

@Repository // 스프링빈으로등록
public class MemberRepository {
	private List<MemberDTO> list = new ArrayList<>();
	private Long sequence = 0L;
		
	
	//회원가입 등록

	public MemberDTO save(@ModelAttribute MemberDTO member) {
		member.setId(++sequence);
		list.add(member);
		return member;
		
	}
	//회원목록

	public List<MemberDTO> findAll(){
		return list;
	}
}
