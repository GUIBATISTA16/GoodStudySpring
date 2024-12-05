package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Explicador;
import com.gooodstudy.goodstudyspring.model.requests.PesquisaRequest;
import com.gooodstudy.goodstudyspring.service.ExplicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/explicadores")
public class ExplicadorController {

    @Autowired
    private ExplicadorService explicadorService;

    @PostMapping("/pesquisa")
    public ResponseEntity<List<Explicador>> getPesquisa(@RequestBody PesquisaRequest request) {
        List<Explicador> list = explicadorService.pesquisa(
                request.getNome(),
                Optional.ofNullable(request.getEspecialidade()),
                request.getPrecoMin(),
                request.getPrecoMax()
        );
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
