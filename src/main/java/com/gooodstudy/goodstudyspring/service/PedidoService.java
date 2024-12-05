package com.gooodstudy.goodstudyspring.service;

import com.gooodstudy.goodstudyspring.model.Pedido;
import com.gooodstudy.goodstudyspring.repository.PedidoRepository;
import com.gooodstudy.goodstudyspring.model.requests.AnswerToPedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido sendPedido(Pedido pedido) {
        //pedido.setData(new Date());
        pedido.setEstado("Waiting");
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getPedidosExplicador(int id) {
        return pedidoRepository.findByExplicadorId(id);
    }

    public List<Pedido> getPedidosExplicando(int id) {
        return pedidoRepository.findByExplicandoId(id);
    }

    public Pedido answerToPedido(AnswerToPedidoRequest answer) {
        if (!answer.getAnswer().equals("Accepted")  && !answer.getAnswer().equals("Rejected"))
            return null;

        Pedido pedido = answer.getPedido();
        pedido.setEstado(answer.getAnswer());
        return pedidoRepository.save(pedido);
    }
}
