package com.example.demo.controller;



import com.example.demo.domain.Member.MemberEntity;
import com.example.demo.domain.board.BoardRepository;

import com.example.demo.domain.file.FileEntity;
import com.example.demo.domain.file.FileRepository;
import com.example.demo.dto.board.BoardDto;
import com.example.demo.dto.file.FileDto;
import com.example.demo.service.board.BoardService;
import com.example.demo.service.file.FileService;
import com.example.demo.service.member.MemberService;
import com.example.demo.util.file.MD5Generator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private FileService fileService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/board/info")
    public String listInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        MemberEntity memberDtoList = memberService.getMember(username);


        model.addAttribute("member", memberDtoList);
        return "/listInfo";
    }

    //글 저장 Controller
    //첨부파일 등록
    @PostMapping("/board/writing")
    public String write(@RequestParam("file") List<MultipartFile> files, BoardDto boardDto) {
        try {
            String originalName = null;
            String filename = null;
            String filePath = null;
            Long fileId = null;
            FileDto fileDto = new FileDto();


            Long boardid =  boardService.savePost(boardDto);

            // 파일 업로드(여러개) 처리 부분
            for(MultipartFile file : files) {
                originalName = file.getOriginalFilename();
                filename = new MD5Generator(originalName).toString();
                /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
                String savePath = System.getProperty("user.dir") + "\\files";
                /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
                if (!new File(savePath).exists()) {
                    try{
                        new File(savePath).mkdir();
                    }
                    catch(Exception e){
                        e.getStackTrace();
                    }
                }
                filePath = savePath + "\\" + filename;
                file.transferTo(new File(filePath));

                fileDto = new FileDto();
                fileDto.setOrigFilename(originalName);
                fileDto.setFilename(filename);
                fileDto.setFilePath(filePath);
                fileDto.setBoardid(boardid);
                fileId = fileService.saveFile(fileDto);
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/board/list";
    }


    //All Show
    //목록 출력에 페이징 처리
    @GetMapping("/board/list")
    public String boardListAll(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
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

    //Update
    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post", boardDto);
        return "/edit";
    }

    @PostMapping("/post/edit/{id}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/board/list";
    }

    //Delete
    @PostMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.deletePost(id);
        fileService.deleteFile(id);
        return "redirect:/board/list";
    }

    //Search
    @GetMapping("/board/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
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

    //Detail
    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);
        List<FileEntity> filelist = fileRepository.findByBoardid(id);

        model.addAttribute("post", boardDto);
        model.addAttribute("fileList", filelist);
        return "detail";
    }


    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> fileDownload(@PathVariable("fileId") Long fileId) throws IOException {
        FileDto fileDto = fileService.getFile(fileId);
        Path path = Paths.get(fileDto.getFilePath());
        Resource resource = new InputStreamResource(Files.newInputStream(path));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDto.getOrigFilename() + "\"")
                .body(resource);
    }

}
