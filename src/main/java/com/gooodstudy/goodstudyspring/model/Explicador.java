package com.gooodstudy.goodstudyspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@DiscriminatorValue("explicador")
public class Explicador extends Pessoa{

    //Explicador
    private String descricao;

    @ManyToOne
    private Especialidade especialidade;

    private int precohora;
    private int precomes;
    private int precoano;
    //Explicador
}
