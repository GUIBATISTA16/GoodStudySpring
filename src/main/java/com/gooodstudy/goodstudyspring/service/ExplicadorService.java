package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Explicador;
import com.gooodstudy.goodstudyspring.repository.ExplicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ExplicadorService {

    @Autowired
    ExplicadorRepository explicadorRepository;

    public Explicador saveExplicador(Explicador explicador, Optional<MultipartFile> file) throws IOException {
        if (file.isPresent()) {
            MultipartFile multipartFile = file.get();
            explicador.setImageName(multipartFile.getOriginalFilename());
            explicador.setImageType(multipartFile.getContentType());
            explicador.setImageData(multipartFile.getBytes());
        }
        return explicadorRepository.save(explicador);
    }

    public List<Explicador> getAllExplicadores() {
        return explicadorRepository.findAll();
    }
}
