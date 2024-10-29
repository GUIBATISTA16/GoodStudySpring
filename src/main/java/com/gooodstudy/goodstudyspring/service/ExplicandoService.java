package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Explicando;
import com.gooodstudy.goodstudyspring.repository.ExplicandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ExplicandoService {

    @Autowired
    ExplicandoRepository explicandoRepository;

    public Explicando saveExpliando(Explicando explicando, Optional<MultipartFile> file) throws IOException {
        if (file.isPresent()) {
            MultipartFile multipartFile = file.get();
            explicando.setImageName(multipartFile.getOriginalFilename());
            explicando.setImageType(multipartFile.getContentType());
            explicando.setImageData(multipartFile.getBytes());
        }
        return explicandoRepository.save(explicando);
    }

    public List<Explicando> getAllExplicandos() {
        return explicandoRepository.findAll();
    }
}
