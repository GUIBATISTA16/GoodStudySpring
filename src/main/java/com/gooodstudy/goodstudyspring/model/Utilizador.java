package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Utilizador {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String email;

    private String password;

    //1- Explicador
    //2- Explicando
    private int tipodeconta;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    //Explicando
    private int idade;

    private String distrito;
    //Explicando

    //Explicador
    private String descricao;

    @ManyToOne
    private Especialidade especialidade;


    private int precohora;
    private int precomes;
    private int precoano;
    //Explicador
}
