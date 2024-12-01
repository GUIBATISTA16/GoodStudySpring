package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Pessoa;
import com.gooodstudy.goodstudyspring.repository.PessoaRepository;
import com.gooodstudy.goodstudyspring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @Autowired
    PessoaService pessoaService;

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
        Pessoa pessoa = pessoaService.getPessoaById(id);
        if (pessoa == null) {
            return "home";
        }
        model.addAttribute("pessoa", pessoa);
        return "perfil";
    }
}
