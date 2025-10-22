package com.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@Builder
public class User {
	private String id;
	private String pw;

}
