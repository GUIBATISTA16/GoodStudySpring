package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Explicador;
import com.gooodstudy.goodstudyspring.model.Explicando;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplicandoRepository extends JpaRepository<Explicando, Integer> {

}
