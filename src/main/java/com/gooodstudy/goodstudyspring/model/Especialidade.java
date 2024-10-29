package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Especialidade {

    @Id
    int id;

    String nome;

}
