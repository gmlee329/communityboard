package com.example.backend.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {
    @GetMapping("test")
    public HashMap test() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("test", "ok");
        return hashMap;
    }
}
