package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
