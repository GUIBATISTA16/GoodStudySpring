package com.gooodstudy.goodstudyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("")
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping("/createaccount")
    public String createAccountPage(Model model) {
        return "createaccount";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        return "home";
    }

    @GetMapping("/perfil/{id}")
    public String perfilPage(Model model, @PathVariable("id") int id) {
        return "perfil";
    }
}
