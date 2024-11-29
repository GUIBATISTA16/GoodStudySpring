package com.gooodstudy.goodstudyspring.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@DiscriminatorValue("explicando")
public class Explicando extends Pessoa{

    //Explicando
    private int idade;

    private String distrito;
    //Explicando
}
