package com.mksong.mkboard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mksong.mkboard.dto.BoardDTO;
import com.mksong.mkboard.dto.PageRequestDTO;
import com.mksong.mkboard.dto.PageResponseDTO;
import com.mksong.mkboard.mappers.BoardMapper;
import com.mksong.mkboard.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    // private final BoardMapper boardMapper;

    @GetMapping("/list")
        public void list(PageRequestDTO pageRequestDTO, Model model){

        PageResponseDTO<BoardDTO> pageResponseDTO
                = service.getList(pageRequestDTO);

        model.addAttribute("pageResponseDTO", pageResponseDTO);

    }

    @GetMapping("/read/{bno}")
        public String read(@PathVariable("bno") Long bno,
                        BoardDTO boardDTO,
                        PageRequestDTO pageRequestDTO,
                        Model model){

        log.info("read.....");
        log.info(bno);

        boardDTO = service.readBoard(bno);

        log.info(boardDTO);

        model.addAttribute("board", boardDTO);

        return "board/read";
    }

    @GetMapping("/regist")
    public void getRegist(BoardDTO boardDTO){
        log.info("get regist");
    }
    
    @PostMapping("/regist")
    public String postRegist(BoardDTO boardDTO){

        service.registBoard(boardDTO);

        return "redirect:/board/list";
    }

    // @GetMapping("/lteLayout")
    // public void getLayout (){
    //     log.info("layout...");
    // }

    @GetMapping("/modify/{bno}")
    public String getModify(@PathVariable("bno") Long bno, Model model){

        log.info("get modify......");
        model.addAttribute("board", service.readBoard(bno));



        return "/board/modify";
    }

    @PostMapping("/modify/{bno}")
    public String postModify(Long bno, BoardDTO boardDTO){

        log.info("postModify......");
        service.modifyBoard(boardDTO);

        return "redirect:/board/read/" + bno;
    }

    @PostMapping("/delete/{bno}")
    public String postDelete(@PathVariable("bno") Long bno){

        log.info(bno);

        service.deleteBoard(bno);

        return "redirect:/board/list";
    }


}
