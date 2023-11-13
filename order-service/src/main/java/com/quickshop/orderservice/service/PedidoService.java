package com.quickshop.orderservice.service;

import com.quickshop.orderservice.dto.PedidoRequest;
import com.quickshop.orderservice.model.Pedido;
import com.quickshop.orderservice.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PedidoService {

    private final PedidoRepository repository;

    public void savePedido(PedidoRequest request) {
        Pedido pedido = new Pedido();
        pedido.setCodigo(String.valueOf(UUID.randomUUID()));
        pedido.setDetalhes(request.getDetalhes());
        //  verify product on inventory ...

        repository.save(pedido);
        log.info("Pedido {} salvo com sucesso", pedido);
    }


}
