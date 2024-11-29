package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Especialidade;
import com.gooodstudy.goodstudyspring.model.Explicador;
import com.gooodstudy.goodstudyspring.repository.ExplicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExplicadorService {

    @Autowired
    private ExplicadorRepository explicadorRepository;

    public List<Explicador> findAllExplicadores() {
        // Busca todos os explicadores no banco
        return explicadorRepository.findAll();
    }

    public List<Explicador> pesquisa(String nome, Optional<Especialidade> especialidade, Integer precoMin, Integer precoMax) {
        List<Explicador> users;
        String nomePesquisa = "";
        if (nome != null){
            nomePesquisa = nome;
        }
        System.out.println("nome: " + nome);
        if (especialidade.isPresent()) {
            users = explicadorRepository.pesquisarExplicadorEsp(nomePesquisa,precoMin,precoMax,especialidade.get());
        }
        else {
            users = explicadorRepository.pesquisarExplicadorBasic(nomePesquisa,precoMin,precoMax);
        }
        return users;
    }
}
