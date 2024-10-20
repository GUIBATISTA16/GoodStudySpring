package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Explicador {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    String nome;

    String descricao;

    @OneToOne
    Especialidade especialidade;

    int precohora;
    int precomes;
    int precoano;
}
