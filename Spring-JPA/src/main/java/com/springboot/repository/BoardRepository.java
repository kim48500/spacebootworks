package com.springboot.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Board;


import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Integer>{
   //save(), findById(), findAll(), delete()
	//쿼리 메서드 글제목 그차체로 검색
	List<Board> findByTitle(String searchKeyword);
	
	//특정 단어가 포함된 글 내용 검색
	List<Board> findByTitleContaining(String searchKeyword);
	//특정 단어가 포함 글을 내림차순으로 정렬
	List<Board> findByTitleContainingOrderByIdDesc(String searchKeyword);
	//제목 검색어가 포함된 글 목록을 페이지로 처리하여 조회
    //List<Board> findByTitleContaining(String searchKeyword, Pageable page);
	//제목 검색어가 포함된 글 목록을 페이지로 처리하여 조회
    Page<Board> findByTitleContaining(String searchKeyword, Pageable page);
}
