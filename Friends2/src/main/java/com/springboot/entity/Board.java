package com.springboot.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.springboot.dto.BoardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Table(name = "t_board")
@Entity

public class Board {
	    @Id
	    @GeneratedValue(strategy   = GenerationType.IDENTITY)
		private Long   id;//글번호
	    @Column(nullable=false)
		private String title;	//글제목
	    @Column(length=400, nullable=false)
		private String content;//글내용
	    @Column(length=30, nullable=false)
		private String writer;//작성자
	    
	    @Column(columnDefinition = "Integer default 0")
		private Integer hits; //조회수
	    
		@CreationTimestamp
		private Timestamp regDate;//작성일
		//dto를 엔티티로
		public static Board tosaveEntity(BoardDTO dto) {
			Board board = new Board();
			board.setTitle(dto.getTitle());
			board.setContent(dto.getContent());
			board.setHits(0);
			board.setWriter(dto.getWriter());
			
			return board;
			
			
			
		}
		
}
