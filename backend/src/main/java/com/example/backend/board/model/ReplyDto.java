package com.example.backend.board.model;

import lombok.Data;

@Data
public class ReplyDto {
    private int replyNo;
    private int docNo;
    private String writer;
    private String content;
    private String regDttm;
}
