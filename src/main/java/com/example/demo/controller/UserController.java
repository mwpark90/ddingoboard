package com.example.demo.controller;

import com.example.demo.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class UserController {

    private MemberService memberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String mainView(){

        return "Hello";
    }




}
