package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Integer> {

    @Query("SELECT u FROM Utilizador u WHERE u.email = ?1")
    Utilizador findByEmail(String emailAddress);

    @Query("SELECT u.id FROM Utilizador u WHERE u.email = ?1")
    Integer findIdByMail(String emailAddress);

}
