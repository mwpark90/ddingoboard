package com.example.demo.controller;

import com.example.demo.domain.Member.MemberEntity;
import com.example.demo.domain.file.FileEntity;
import com.example.demo.dto.board.BoardDto;
import com.example.demo.dto.file.FileDto;
import com.example.demo.dto.member.MemberDto;
import com.example.demo.service.board.BoardService;
import com.example.demo.service.file.FileService;
import com.example.demo.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AdminController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private FileService fileService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/admin/list")
    public String boardListAll(Model model) {
        List<BoardDto> boardDtoList = boardService.getBoardAllList();
        List<FileEntity> fileDtoList = fileService.getAllFile();
        List<MemberEntity> memberDtoList = memberService.getAllMember();

        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("boardfileList", fileDtoList);
        model.addAttribute("memberList", memberDtoList);
        return "/admin";
    }




}
