package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.*;
import com.gooodstudy.goodstudyspring.repository.DadosRepository;
import com.gooodstudy.goodstudyspring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DadosService {

    @Autowired
    DadosRepository dadosRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Dados saveUser(Dados conta, Pessoa pessoa, Optional<MultipartFile> file) throws IOException {
        if (file.isPresent()) {
            MultipartFile multipartFile = file.get();
            pessoa.setImageName(multipartFile.getOriginalFilename());
            pessoa.setImageType(multipartFile.getContentType());
            pessoa.setImageData(multipartFile.getBytes());
        }
        Pessoa p;
        if (conta.getTipodeconta() == 1) { // Explicador
            Explicador explicador = (Explicador) pessoa;
            p = pessoaRepository.save(explicador);
        } else if (conta.getTipodeconta() == 2) { // Explicando
            Explicando explicando = (Explicando) pessoa;
            p = pessoaRepository.save(explicando);
        } else {
            throw new IllegalArgumentException("Tipo de conta inválido.");
        }
        conta.setPessoa(p);
        conta.setPassword(bCryptPasswordEncoder.encode(conta.getPassword()));

        return dadosRepository.save(conta);
    }
}
