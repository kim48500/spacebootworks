package com.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dto.BoardDTO;
import com.springboot.entity.Board;
import com.springboot.service.BoardServic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/boards")
@Controller //빈(bean)등록
public class BoardController {
	private final BoardServic service;
	//계시글 목록
      @GetMapping
      public String getBoardList(Model model) {
    	  List<Board> boardList =service.findAll();
    	  model.addAttribute("boardList",boardList);
    	  return "board/list";
      }
      //계시글 목록 페이지처리 검색
      @GetMapping("/pages")
      public String getBoardPages(
    		  @RequestParam(value="keyword",required = false) String keyword,
    		  @RequestParam(value="type", required = false) String type,
    		  @PageableDefault(page=1)Pageable pageable,
    		  Model model) {
    	  
    	  Page<Board> boardList = null;
    			  if(keyword == null) {
    				  boardList=service.findAll(pageable);
    			  }else if(keyword != null && type.equals("title")){
    				  boardList=service.findByTitleContaining(keyword,pageable);
    			  }else if(keyword != null && type.equals("content")){
    				  boardList=service.findByContentContaining(keyword,pageable);
    			  }
    	  //Page<Board> boardList =service.findAll(pageable);
    	  //하단의 페이지블럭
    	  int blockLimit = 10; //1 2 3....10 (10페이지까지보이기
    	  
    	  //페이지블럭의 시작번호  1   11  21
    	  //예)페이지번호-13, 13/10=1.3 2(올림) -1*10+1 => 11~20블럭
    	 int startPage =
    			(int)Math.ceil((double)pageable.getPageNumber() / blockLimit -1)
    			* blockLimit + 1;
    	 //페이지블럭의 끝번호 10 20 30
    	 //int endPage = startPage + blockLimit - 1 
    	 
    	// int endPage = (startPage + blockLimit - 1 ) > boardList.getTotalPages()?
    			// boardList.getTotalPages() : (startPage + blockLimit -1);
    	 int endPage = Math.min(startPage+ blockLimit - 1, boardList.getTotalPages());
     			 
    	//모델 보내기
    	model.addAttribute("boardList",boardList);//리스트보내기		 
    	 model.addAttribute("startPage",startPage);
    	 model.addAttribute("endPage",endPage);
    	 model.addAttribute("kw",keyword); //검색어보내기
    	 model.addAttribute("type",type);//검색유효ㅕㅇ
    	
    	  
    	  return "board/pages";
      }
      
	
	//글쓰기페이지
	@GetMapping("/write")
	public String writeForm() {
		return "board/write";
	}
	//글쓰기 처리
	@PostMapping("/write")
	public String wirte(@ModelAttribute BoardDTO dto) {
		log.info("BoardDTO" + dto);
		service.save(dto);
		return "redirect:/boards/pages";
	}
	//글상세보기
	@GetMapping("/{id}")
	public String getBoard(@PathVariable Long id,
			@PageableDefault(page=1) Pageable pageable,
			Model model) {
		try {//조회수 증가
                 service.updateHits(id);
			
			
			Board board = service.findById(id);
			 model.addAttribute("board",board);
			 model.addAttribute("page", pageable.getPageNumber()); //해당페이지로
			 return "board/detail";
		} catch (Exception e) {
			return "error/errorPage";
		}
		
		
	}
	//글 삭제
@GetMapping("/delete/{id}")
public String deleteBoard(@PathVariable Long id) {
	service.delete(id);
	return "redirect:/boards";
}
//글수정페이지
@GetMapping("/update/{id}")
public String updateForm(@PathVariable Long id,
		Model model) {
	Board board = service.findById(id); //해당계시글 가져오
	model.addAttribute("board",board);// 수정방식
	return "board/update";
}
//글 수정 처리
@PostMapping("/update")
public String updateBoard(BoardDTO dto) {
	service.update(dto);
	return "redirect:/boards/" + dto.getId();
}
	
}
      
