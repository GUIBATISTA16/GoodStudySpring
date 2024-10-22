package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Explicador {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String descricao;

    @OneToOne
    private Especialidade especialidade;

    private int precohora;
    private int precomes;
    private int precoano;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

}
