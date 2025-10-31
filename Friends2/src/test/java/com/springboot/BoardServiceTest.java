package com.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.dto.BoardDTO;
import com.springboot.service.BoardServic;

@SpringBootTest
public class BoardServiceTest {
	@Autowired//객체생성
	private BoardServic service;
	
	@Test
	void TestInserData() {
		for(int i=1; i <=123; i++) {
			BoardDTO dto = new BoardDTO();
			dto.setTitle("테스트제목 " +i);
			dto.setContent("내용 "+i);
			dto.setWriter("tester");
			
			service.save(dto);
		}
	}
	

}
