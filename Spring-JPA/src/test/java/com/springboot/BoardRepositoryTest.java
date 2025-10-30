package com.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysql.cj.log.Log;
import com.springboot.entity.Board;
import com.springboot.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
private BoardRepository repository;
	
	//계시글추가
	/*
	 * @Test
	 * public void insertBorad() {
	 */
		/*Board board = new Board();
		board.setTitle("가입인사");
		board.setWriter("김모쿤");
		board.setContent("안녕 나는 ");
		
		repository.save(board);
		Board board = Board.builder()
				.title("나는간다")
				.writer("이모쿤")
				.content("만나서반갑습니다")
				.build();
		repository.save(board);
				//계시글목록
	}*/
	/*
}*/
//계시글 상세보기 1(1건보기
	
	
	//계시글수정
	/*@Test
	public void updateBoard() {
		log.info("===2번계시글 조회==");
		Board board = repository.findById(2).get();
		
		log.info("===2번계시글 제목수정==");
		board.setTitle("제목을 수정합니다");
		//수정후 저장

		repository.save(board);
		
		
	}
	@Test
	public void getBoard() {
log.info("===2번계시글 조회==");
Optional<Board> board = repository.findById(2);
log.info("-->"+board.toString());
}*/
	//계시글 삭제
/*@Test
public void deleteBoard() {
	log.info("===1번계시글삭제");
	repository.deleteById(1);
}*/
//계시글목록
@Test
public void getBoardList() {
	List<Board> boardList =repository.findAll();
	for(Board board : boardList) {
		//System.out.println(board.toString());
		log.info("-->"+board.toString());
	}
	
}
}
