package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspRepository extends JpaRepository<Especialidade, Integer> {
}
