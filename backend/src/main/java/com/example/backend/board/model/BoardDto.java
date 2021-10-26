package com.example.backend.board.model;

import lombok.Data;

@Data
public class BoardDto {
    private int docNo;
    private String title;
    private String content;
    private String writer;
    private String regDttm;
    private int viewCount;
    private int replyCount;
}
