package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;

@Entity
public class Explicando {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nome;

    private int idade;

    private String distrito;


    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
}
