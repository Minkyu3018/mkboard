package com.mksong.mkboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDTO {

    private Long bno;
    private String title;
    private String writer;
    private String content;
    private boolean complete;
    private String dueDate;
    
}
