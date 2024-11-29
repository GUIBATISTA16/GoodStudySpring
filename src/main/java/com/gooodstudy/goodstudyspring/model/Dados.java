package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Dados {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String email;

    private String password;

    //1- Explicador
    //2- Explicando
    private int tipodeconta;

    @ManyToOne
    private Pessoa pessoa;
}
