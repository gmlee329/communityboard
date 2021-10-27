package com.example.backend.board.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAllException(Exception e) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("message", "error");

        return hashMap;
    }
}
