package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Especialidade;
import com.gooodstudy.goodstudyspring.repository.EspRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspService {

    @Autowired
    EspRepository repo;

    public List<Especialidade> getEspecialidades() {
        return repo.findAll();
    }
}
