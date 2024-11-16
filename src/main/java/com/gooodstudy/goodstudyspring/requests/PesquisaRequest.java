package com.gooodstudy.goodstudyspring.requests;

import com.gooodstudy.goodstudyspring.model.Especialidade;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PesquisaRequest {

    private String nome;
    private Especialidade especialidade;
    private Integer precoMin;
    private Integer precoMax;

}
