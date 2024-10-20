package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Explicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplicadorRepository extends JpaRepository<Explicador, Integer> {

}
