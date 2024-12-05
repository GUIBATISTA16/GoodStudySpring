package com.gooodstudy.goodstudyspring.model.requests;

import com.gooodstudy.goodstudyspring.model.Pedido;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnswerToPedidoRequest {

    Pedido pedido;

    String answer;

}
