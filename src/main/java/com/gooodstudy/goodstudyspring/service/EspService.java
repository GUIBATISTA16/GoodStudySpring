package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Especialidade;
import com.gooodstudy.goodstudyspring.repository.EspRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspService {

    @Autowired
    EspRepository repo;

    @EventListener(ApplicationReadyEvent.class)
    public void innitialize() {
        List<Especialidade> list = new ArrayList<>(){{
            add(new Especialidade(1,"Português"));
            add(new Especialidade(2,"Matemática"));
            add(new Especialidade(3,"Ciências"));
            add(new Especialidade(4,"Fisica e Química"));
            add(new Especialidade(5,"Filosofia"));
            add(new Especialidade(6,"Inglês"));
        }};
        repo.saveAll(list);
    }

    public List<Especialidade> getEspecialidades() {
        return repo.findAll();
    }
}
