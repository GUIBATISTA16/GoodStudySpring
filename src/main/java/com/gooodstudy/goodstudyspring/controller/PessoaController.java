package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Pessoa;
import com.gooodstudy.goodstudyspring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoa (@PathVariable("id") int id) {

        Pessoa pessoa = pessoaService.getPessoa(id);
        if (pessoa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

}
