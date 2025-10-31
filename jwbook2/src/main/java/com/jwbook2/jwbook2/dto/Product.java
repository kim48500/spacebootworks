package com.jwbook2.jwbook2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data  //getter, setter, tostring 포함
public class Product {
	//제약 사항 메시지: 비어있을 수 없습니다.
	@NotEmpty
	private String name; //상품명
	
	//0 이상이어야 합니다.
	@Min(value=0)
	private Integer price;   //가격
}
