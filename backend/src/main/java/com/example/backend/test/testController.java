package com.example.backend.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class testController {
    @GetMapping("/test")
    public HashMap test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("test", "ok");
        return map;
    }
}
