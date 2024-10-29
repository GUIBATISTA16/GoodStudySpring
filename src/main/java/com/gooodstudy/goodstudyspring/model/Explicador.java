package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
@Getter
@Setter
@ToString
@Entity
public class Explicador {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String descricao;

    @ManyToOne
    private Especialidade especialidade;

    private String email;

    private String password;

    private int precohora;
    private int precomes;
    private int precoano;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

}
