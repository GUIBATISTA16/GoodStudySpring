package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Dados;
import com.gooodstudy.goodstudyspring.model.Pessoa;
import com.gooodstudy.goodstudyspring.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class DadosController {

    @Autowired
    DadosService dadosService;

    @PostMapping("/criarconta")
    public ResponseEntity<?> saveUser(@RequestPart Dados conta, @RequestPart Pessoa pessoa,
                                      @RequestPart Optional<MultipartFile> file) {
        try {
            Dados dados = dadosService.saveUser(conta,pessoa,file);
            if (dados != null) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Error saving data",HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
