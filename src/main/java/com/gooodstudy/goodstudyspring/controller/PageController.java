package com.gooodstudy.goodstudyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("")
    public String loginPage(Model model) {
        model.addAttribute("title", "Welcome to the Good Study");
        return "login";
    }
}
