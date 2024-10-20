package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Explicando {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    String nome;

    int idade;

    String distrito;


}
