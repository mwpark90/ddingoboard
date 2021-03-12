package com.example.demo.controller;


import com.example.demo.domain.book.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class BoardController {

    @Autowired
    private BookRepository bookRepository;

    //Create
    //첨부파일 등록
    @GetMapping("/board/info")
    public String listInfo() {
        return "/listInfo";
    }

    //All Show
    //목록 출력에 페이징 처리
    @GetMapping("/board/list")
    public String dispSignup() {
        return "/boardlist";
    }
    //Update

    //Delete

    //Search





}
