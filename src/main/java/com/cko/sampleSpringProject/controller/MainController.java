package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "login";

    }
    @GetMapping("/")
    public String showMainPage() {
        return "mainPage";
    }

    @GetMapping("/game")
    public String showTikTakToe() {
        return "file";
    }

    @GetMapping("/test")
    public String testing() {
        return "test";
    }

}
