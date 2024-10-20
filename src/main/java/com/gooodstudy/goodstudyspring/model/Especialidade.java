package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Especialidade {

    @Id
    int id;

    String nome;

}
