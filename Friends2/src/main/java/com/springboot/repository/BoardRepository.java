package com.springboot.repository;



import org.springframework.data.domain.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	//
   @Modifying
   @Query(value="update Board b set b.hits=b.hits+1 where b.id=:id")
   void updateHits(Long id);
   
   //제목검색어가 포함되 계시글 
   Page<Board> findByTitleContaining(String keyword,
		   Pageable pageable);
   //내용에 특정 검색어가 포함된 계시글 목록을 처리하여 조화
   Page<Board> findByContentContaining(String keyword,
		   Pageable pageable);
}
