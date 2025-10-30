package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor//매개변수를 모두가진 생성자
@NoArgsConstructor//기본생성자
@ToString
@Getter
@Setter
public class MemberDTO {
	private Long id; //번호 순번
	private String name;//이름
    private String email;
	
}
