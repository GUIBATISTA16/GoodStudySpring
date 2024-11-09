package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Utilizador;
import com.gooodstudy.goodstudyspring.service.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class UtilizadorController {

    @Autowired
    UtilizadorService utilizadorService;

    @PostMapping("/user/save")
    public ResponseEntity<?> saveUser(@RequestPart Utilizador conta,
                                      @RequestPart Optional<MultipartFile> file) {
        try {
            Utilizador userSaved = utilizadorService.saveUser(conta,file);
            return new ResponseEntity<>(utilizadorService, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/utilizadores")
    public ResponseEntity<List<Utilizador>> getExplicadores() {
        List<Utilizador> list = utilizadorService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK) ;
    }
}
