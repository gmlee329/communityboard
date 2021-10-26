package com.example.backend.board.model;

import lombok.Data;

@Data
public class OptionDto {
    private String schType;
    private String schVal;
    private int startNo;
    private int endNo;
    private String[] sort;
}
