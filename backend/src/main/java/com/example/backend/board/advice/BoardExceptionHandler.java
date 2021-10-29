package com.example.backend.board.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BoardExceptionHandler {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String noHandlerFound(NoHandlerFoundException e) {
        return "index.html";
    }

//    @ExceptionHandler(Exception.class)
//    public Map<String, String> handleAllException(Exception e) {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("message", "error");
//
//        return hashMap;
//    }
}
