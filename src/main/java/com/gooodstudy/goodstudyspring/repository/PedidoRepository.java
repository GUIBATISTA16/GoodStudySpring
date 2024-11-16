package com.gooodstudy.goodstudyspring.repository;

import com.gooodstudy.goodstudyspring.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p from Pedido p where p.explicador.id = ?1 and p.estado = 'Waiting'")
    List<Pedido> findByExplicadorId(int id);

    @Query("SELECT p from Pedido p where p.explicando.id = ?1 and p.estado = 'Waiting'")
    List<Pedido> findByExplicandoId(int id);
}
