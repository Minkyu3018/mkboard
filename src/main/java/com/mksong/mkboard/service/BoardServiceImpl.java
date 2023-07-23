package com.mksong.mkboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mksong.mkboard.dto.BoardDTO;
import com.mksong.mkboard.dto.PageRequestDTO;
import com.mksong.mkboard.dto.PageResponseDTO;
import com.mksong.mkboard.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {

        List<BoardDTO> list = boardMapper.list(pageRequestDTO);
        long total = boardMapper.listCount(pageRequestDTO);
    
        return PageResponseDTO.<BoardDTO>withAll()
        .list(list)
        .total(total)
        .build();
    }

    @Override
    public int registBoard(BoardDTO boardDTO) {

        return boardMapper.regist(boardDTO);
    }

    @Override
    public BoardDTO readBoard(Long bno) {

        return boardMapper.read(bno);
    }

    @Override
    public int modifyBoard(BoardDTO boardDTO) {

        return boardMapper.modify(boardDTO);
    }

    @Override
    public void deleteBoard(Long bno) {

        boardMapper.delete(bno);
    }


    

}
