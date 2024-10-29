package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Explicando {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nome;

    private int idade;

    private String distrito;

    private String email;

    private String password;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

}
