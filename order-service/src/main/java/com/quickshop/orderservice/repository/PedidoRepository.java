package com.quickshop.orderservice.repository;

import com.quickshop.orderservice.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface   PedidoRepository extends JpaRepository<Pedido, Long> {
}
