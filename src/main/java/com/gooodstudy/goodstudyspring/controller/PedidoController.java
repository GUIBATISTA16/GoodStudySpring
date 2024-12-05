package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.model.Pedido;
import com.gooodstudy.goodstudyspring.model.requests.AnswerToPedidoRequest;
import com.gooodstudy.goodstudyspring.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @PostMapping("sendPedido")
    public ResponseEntity<Pedido> sendPedido(@RequestBody Pedido pedido) {
        Pedido pedidoAdded = pedidoService.sendPedido(pedido);
        if (pedidoAdded != null) {
            return new ResponseEntity<>(pedidoAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @MessageMapping("/sendPedido")
    public void sendPedidoWS(@Payload Pedido pedido) {
        Pedido pedidoAdded = pedidoService.sendPedido(pedido);
        messagingTemplate.convertAndSendToUser(
                String.valueOf(pedidoAdded.getExplicador().getId()),
                "/pedidos",
                pedidoAdded);
    }

    @GetMapping("getPedidos/explicador/{id}")
    public ResponseEntity<List<Pedido>> getPedidosExplicador(@PathVariable int id) {
        return new ResponseEntity<>(pedidoService.getPedidosExplicador(id), HttpStatus.OK);
    }

    @GetMapping("getPedidos/explicando/{id}")
    public ResponseEntity<List<Pedido>> getPedidosExplicando(@PathVariable int id) {
        return new ResponseEntity<>(pedidoService.getPedidosExplicando(id), HttpStatus.OK);
    }

    @PutMapping("/answerPedido")
    public ResponseEntity<Pedido> answerToPedido(@RequestBody AnswerToPedidoRequest answer) {
        Pedido pedidoAnswered = pedidoService.answerToPedido(answer);
        if (pedidoAnswered != null) {
            return new ResponseEntity<>(pedidoAnswered, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
