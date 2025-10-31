package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.dto.BoardDTO;
import com.springboot.entity.Board;
import com.springboot.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor//생성자 주입(final사용
@Service
public class BoardServic {
	//RequiredArgsConstructor 경우 파이날상수키워드 붙임
	private  final BoardRepository repository;
	//글쓰기
	public void save(BoardDTO dto) {
		//dto를 엔티티로 변환메서드 호출 db로 들어갈때는 엔티티가 되야해서 바꿔야함
		Board board=Board.tosaveEntity(dto);

		repository.save(board);
		
		
	}
	public List<Board> findAll() {
		
		return repository.findAll();
	}
	public Board findById(Long id) {
		//id에 해당하는 계시글이 없는경우도 구현한다
		Board board =repository.findById(id)
				.orElseThrow(()->
				new IllegalArgumentException("해당글이 존재하지않습니다"));
		return board;
	}
	//조회수 증가
	@Transactional
	public void updateHits(Long id) {
		repository.updateHits(id);
		
		
	}
	//글 삭제
	public void delete(Long id) {
		//제공된 deleteById()사용
  repository.deleteById(id);		
	}
	//글 수정
	public void update(BoardDTO dto) {
		//id에 해당하는 계시글 가져오기
		Board board =repository.findById(dto.getId())
				.orElseThrow(()->
				new IllegalArgumentException("해당글이 존재하지않습니다"));
		//제목 내용수정
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		repository.save(board);
	
		
	}
	public Page<Board> findAll(Pageable pageable) {
		//pageable = PageRequest.of(0,10);
		int page =pageable.getPageNumber() -1;
		int pageSize=10;
		log.info("pageable.getnumber():" + pageable.getPageNumber());
		//pageable = PageRequest.of(page,pageSize);
		pageable = PageRequest.of(page,pageSize,Sort.Direction.DESC,"id");
		Page<Board> boardList =repository.findAll(pageable);
		
		return boardList;
	}

	
    //글제목을 검색
	public Page<Board> findByTitleContaining(String keyword, Pageable pageable) {
		int page =pageable.getPageNumber() -1;
		int pageSize=10;
	
		
		pageable = PageRequest.of(page,pageSize,Sort.Direction.DESC,"id");
		Page<Board> boardList =
				repository.findByTitleContaining(keyword, pageable);
		return boardList;
	}
	//글내용을 검색
	public Page<Board> findByContentContaining(String keyword, Pageable pageable) {
		int page =pageable.getPageNumber() -1;
		int pageSize=10;
	
		
		pageable = PageRequest.of(page,pageSize,Sort.Direction.DESC,"id");
		Page<Board> boardList =
				repository.findByContentContaining(keyword, pageable);
		return boardList;
	}
	
	
	
	

}
