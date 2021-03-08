package com.example.demo.controller;


import com.example.demo.domain.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BookRepository bookRepository;

    //Create
    //첨부파일 등록

    //All Show
    //목록 출력에 페이징 처리

    //Update

    //Delete

    //Search





}
