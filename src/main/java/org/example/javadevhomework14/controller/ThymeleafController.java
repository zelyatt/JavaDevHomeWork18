package org.example.javadevhomework14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/test")
    public String testThymeleaf() {
        return "test";
    }
}
