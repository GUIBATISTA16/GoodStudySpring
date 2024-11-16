package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Utilizador explicador;

    @ManyToOne
    private Utilizador explicando;

    private String estado;

    private Date data = new Date();

    private String texto;
}
