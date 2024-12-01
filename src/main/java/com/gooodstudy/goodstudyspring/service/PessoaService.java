package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Dados;
import com.gooodstudy.goodstudyspring.model.Explicador;
import com.gooodstudy.goodstudyspring.model.Explicando;
import com.gooodstudy.goodstudyspring.model.Pessoa;
import com.gooodstudy.goodstudyspring.repository.ExplicadorRepository;
import com.gooodstudy.goodstudyspring.repository.ExplicandoRepository;
import com.gooodstudy.goodstudyspring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ExplicadorRepository explicadorRepository;

    @Autowired
    ExplicandoRepository explicandoRepository;

    public Pessoa getPessoaById(int id) {
        return pessoaRepository.findById(id).orElse(null);
    }
}
