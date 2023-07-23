package com.mksong.mkboard.mappers;

import java.util.List;

import com.mksong.mkboard.dto.BoardDTO;
import com.mksong.mkboard.dto.PageRequestDTO;

public interface BoardMapper {
    
    List<BoardDTO> list(PageRequestDTO pageRequestDTO);

    long listCount(PageRequestDTO pageRequestDTO);        
 
    int insert(BoardDTO boardDTO);

    // 등록
    int regist(BoardDTO boardDTO);

    // 조회
    BoardDTO read(Long bno);

    // 수정
    int modify(BoardDTO boardDTO);

    // 삭제
    void delete(Long bno);


}
