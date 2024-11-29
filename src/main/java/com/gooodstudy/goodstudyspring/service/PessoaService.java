package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Pessoa;
import com.gooodstudy.goodstudyspring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa getPessoa(int id) {
        return pessoaRepository.findById(id).orElse(null);
    }
}
