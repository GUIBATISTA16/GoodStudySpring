package com.gooodstudy.goodstudyspring.controller;


import com.gooodstudy.goodstudyspring.model.Especialidade;
import com.gooodstudy.goodstudyspring.service.EspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EspController {

    @Autowired
    EspService espService;

    @GetMapping("/especialidades")
    public ResponseEntity<List<Especialidade>> getEspecialidades() {
        List<Especialidade> especialidades = espService.getEspecialidades();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

}
