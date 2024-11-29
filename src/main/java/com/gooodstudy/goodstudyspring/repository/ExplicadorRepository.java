package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Especialidade;
import com.gooodstudy.goodstudyspring.model.Explicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExplicadorRepository extends JpaRepository<Explicador, Integer> {

    @Query("SELECT e FROM Explicador e where e.precohora between ?2 and ?3 and UPPER(e.nome) like UPPER(CONCAT(?1,'%'))")
    List<Explicador> pesquisarExplicadorBasic(String nome, int priceMin, int priceMax);

    @Query("SELECT e FROM Explicador e where e.precohora between ?2 and ?3 and e.especialidade = ?4 and UPPER(e.nome) like UPPER(CONCAT(?1,'%'))")
    List<Explicador> pesquisarExplicadorEsp(String nome, int priceMin, int priceMax, Especialidade especialidade);

}
