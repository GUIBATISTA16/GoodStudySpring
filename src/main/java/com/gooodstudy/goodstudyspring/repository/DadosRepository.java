package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Dados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DadosRepository extends JpaRepository<Dados,Integer> {

    @Query("SELECT d FROM Dados d WHERE d.email = ?1")
    Dados findByEmail(String emailAddress);
}
