package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Explicando;
import com.gooodstudy.goodstudyspring.service.ExplicandoService;
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
public class ExplicandoController {

    @Autowired
    ExplicandoService explicandoService;

    @PostMapping("/explicando/save")
    public ResponseEntity<?> saveExplicando(@RequestPart Explicando conta,@RequestPart Optional<MultipartFile> file ) {
        try {
            Explicando expliandoSaved = explicandoService.saveExpliando(conta,file);
            return new ResponseEntity<>(expliandoSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/explicandos")
    public ResponseEntity<List<Explicando>> getExplicandos() {
        List<Explicando> list = explicandoService.getAllExplicandos();
        return new ResponseEntity<>(list, HttpStatus.OK) ;
    }
}
