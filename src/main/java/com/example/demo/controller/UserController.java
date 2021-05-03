package com.example.demo.controller;

import com.example.demo.domain.Member.MemberEntity;
import com.example.demo.domain.Member.MemberRepository;
import com.example.demo.dto.board.BoardDto;
import com.example.demo.dto.member.MemberDto;
import com.example.demo.service.board.BoardService;
import com.example.demo.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private MemberRepository memberRepository;


    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin(){

        return "/login";
    }


    

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardDtoList = boardService.getBoardList(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        MemberEntity memberDtoList = memberService.getMember(username);


        model.addAttribute("member", memberDtoList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postList", boardDtoList);

        return "/index";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        MemberEntity memberDtoList = memberService.getMember(username);

        model.addAttribute("member", memberDtoList);
        return "/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "redirect:/admin/list";
    }

    //내정보 수정
    @PostMapping("/user/edit/{id}")
    public String memberEdit(MemberDto memberDto) {
        memberRepository.save(memberDto.toEntity());
        return "redirect:/user/login";
    }

}
