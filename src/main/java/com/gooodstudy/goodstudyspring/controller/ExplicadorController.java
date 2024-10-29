package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Explicador;
import com.gooodstudy.goodstudyspring.service.ExplicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ExplicadorController {

    @Autowired
    ExplicadorService explicadorService;

    @PostMapping("/explicador/save")
    public ResponseEntity<?> saveExplicador(@RequestPart Explicador conta, @RequestPart Optional<MultipartFile> file) {
        try {
            Explicador explicadorSaved = explicadorService.saveExplicador(conta,file);
            return new ResponseEntity<>(explicadorSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/explicadores")
    public ResponseEntity<List<Explicador>> getExplicadores() {
        List<Explicador> list = explicadorService.getAllExplicadores();
        return new ResponseEntity<>(list, HttpStatus.OK) ;
    }
}
