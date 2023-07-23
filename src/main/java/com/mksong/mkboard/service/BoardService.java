package com.mksong.mkboard.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mksong.mkboard.dto.BoardDTO;
import com.mksong.mkboard.dto.PageRequestDTO;
import com.mksong.mkboard.dto.PageResponseDTO;

@Transactional
public interface BoardService {

    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);

    // 등록
    int registBoard(BoardDTO boardDTO);

    // 조회
    BoardDTO readBoard(Long bno);

    // 수정
    int modifyBoard(BoardDTO boardDTO);

    // 삭제
    void deleteBoard(Long bno);

}
