package com.springboot;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springboot.entity.Board;
import com.springboot.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class QueryMethodTest {
	
	@Autowired //repository객체를 생성해줌
	private BoardRepository repository;
	/*@BeforeEach
	public void dataPrepare() {
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			board.setTitle("텍스트제목"+ i);
			board.setWriter("테스터");
			board.setContent("테스터내용"+i);
			repository.save(board);
		
		}
	}
	@Test
	public void testFindBytitle() {
		List<Board> boardList =
		repository.findByTitle("테스트제목 4");
		
		log.info("검색결과");
		for(Board board : boardList) {
			log.info("====>" +board.toString());
		}
	}*/
	
	/*@Test
	public void testFindByTitleContaining() {
		List<Board> boardList=
				repository.findByContentContaining("10");
				log.info("검색결과");
				for(Board board : boardList) {
					log.info("====>" +board.toString());
	}
}*/
	/*@Test
	public void testfindByTitleContainingOrderByIdDesc() {
		List<Board> boardList=
		repository.findByTitleContainingOrderByIdDesc("10");
		log.info("검색결과");
		for(Board board : boardList) {
			log.info("====>" +board.toString());
	}
}*/
	/*@Test
	public void findByTitleContaining() {
		//0 첫 페이지 번호
		//10->페이지당 데이터수
		
		//Pageable paging = PageRequest.of(0, 10);
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC,"id"); //내림차순
		
		List<Board> boardList=
				repository.findByTitleContaining("제목", paging);
		
		log.info("검색결과");
		for(Board board : boardList) {
			log.info("====>" +board.toString());
	}
}*/
	@Test
	public void findByTitleContaining() {
		//0 첫 페이지 번호
		//10->페이지당 데이터수
		
		//Pageable paging = PageRequest.of(0, 10);
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC,"id"); //내림차순
		//페이지 정보 객체 생성
		Page<Board> pageInfo=
				repository.findByTitleContaining("제목", paging);
		
		log.info("PAGE SIZE"+ pageInfo.getSize()); //10페에지당 데이터수
		log.info("TOTAL PAGES:"+pageInfo.getTotalPages());
		log.info("Total Count", pageInfo.getTotalElements());
		//log.info("Content:"+pageInfo.getContent()); //저장된 데이터
		List<Board> boardList =pageInfo.getContent();
		log.info("검색결과");
		//for (Board board : boardList) {
	    //    log.info("====>", board.toString());
	  //  }
		//람다식 출력
      boardList.forEach(board -> log.info("--->" + board ));
	}
	
}
