package com.example.demo.controller;


import com.example.demo.domain.board.BoardEntity;
import com.example.demo.domain.board.BoardRepository;
import com.example.demo.domain.book.BookRepository;

import com.example.demo.dto.board.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    //Create
    //첨부파일 등록
    @GetMapping("/board/info")
    public String listInfo() {
        return "/listInfo";
    }

    //글 저장 Controller
    @PostMapping("/board/writing")
    public String boardCreate(BoardDto boardDto) {
        //글 저장
        boardRepository.save(boardDto.toEntity()).getId();
        return "redirect:/board/list";
    }


    //All Show
    //목록 출력에 페이징 처리
    @GetMapping("/board/list")
    public String boardListAll() {
        return "/boardlist";
    }


    //Update



    //Delete



    //Search





}
