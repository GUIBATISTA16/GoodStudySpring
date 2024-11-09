package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Utilizador;
import com.gooodstudy.goodstudyspring.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UtilizadorService {

    int EXPLICADOR_CODE = 1;

    int EXPLICANDO_CODE = 2;

    @Autowired
    private UtilizadorRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Utilizador saveUser(Utilizador user, Optional<MultipartFile> file) throws IOException {
        if (file.isPresent()) {
            MultipartFile multipartFile = file.get();
            user.setImageName(multipartFile.getOriginalFilename());
            user.setImageType(multipartFile.getContentType());
            user.setImageData(multipartFile.getBytes());
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Utilizador u = userRepository.save(user);

        return u;
    }

    public List<Utilizador> getAllUsers() {
        return userRepository.findAll();
    }
}
