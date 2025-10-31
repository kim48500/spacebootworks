package com.springboot.dto;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class BoardDTO {
private Long id;//글번호
@NotEmpty(message="제목은 필수 입력 항목입니다")
private String title;	//글제목
@NotEmpty(message="내용은 필수 입력 항목입니다")
private String content;//글내용
private String writer;//작성자
private Integer hits; //조회수
private Timestamp regDate;//작성일
	
}
