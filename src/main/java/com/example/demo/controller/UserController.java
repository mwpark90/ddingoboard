package com.example.demo.controller;

import com.example.demo.dto.member.MemberDto;
import com.example.demo.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class UserController {

    private MemberService memberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String mainView(){

        return "Hello";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String execSignup(@RequestBody MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "Hello";
    }

}
