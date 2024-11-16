package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Especialidade;
import com.gooodstudy.goodstudyspring.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Integer> {

    @Query("SELECT u FROM Utilizador u WHERE u.email = ?1")
    Utilizador findByEmail(String emailAddress);

    @Query("SELECT u.id FROM Utilizador u WHERE u.email = ?1")
    Integer findIdByMail(String emailAddress);

    @Query("SELECT u FROM Utilizador u where u.tipodeconta = 1 and u.precohora between ?2 and ?3 and UPPER(u.nome) like UPPER(CONCAT(?1,'%'))")
    List<Utilizador> pesquisarExplicadorBasic(String nome, int priceMin, int priceMax);

    @Query("SELECT u FROM Utilizador u where u.tipodeconta = 1 and u.precohora between ?2 and ?3 and u.especialidade = ?4 and UPPER(u.nome) like UPPER(CONCAT(?1,'%'))")
    List<Utilizador> pesquisarExplicadorEsp(String nome, int priceMin, int priceMax, Especialidade especialidade);

}
