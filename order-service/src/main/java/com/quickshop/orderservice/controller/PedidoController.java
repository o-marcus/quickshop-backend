package com.quickshop.orderservice.controller;

import com.quickshop.orderservice.dto.PedidoRequest;
import com.quickshop.orderservice.repository.PedidoRepository;
import com.quickshop.orderservice.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService service;
    @PostMapping
    public void fazerPedido(@RequestBody PedidoRequest request) {
        service.savePedido(request);
    }

}
