package com.quickshop.orderservice.service;

import com.quickshop.orderservice.dto.DetalheRequest;
import com.quickshop.orderservice.dto.EstoqueRequest;
import com.quickshop.orderservice.dto.EstoqueResponse;
import com.quickshop.orderservice.dto.PedidoRequest;
import com.quickshop.orderservice.model.Detalhe;
import com.quickshop.orderservice.model.Pedido;
import com.quickshop.orderservice.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PedidoService {

    private final PedidoRepository repository;
    @Autowired
    private WebClient webClient;

    public void savePedido(PedidoRequest request) throws IllegalArgumentException {
        Pedido pedido = new Pedido();
        List<Detalhe> detalhes = mapDetalheRequestToDetalhe(request.getDetalhes());
        pedido.setCodigo(String.valueOf(UUID.randomUUID()));
        pedido.setDetalhes(detalhes);
        Boolean result = webClient.put()
                .uri("http://localhost:8082/api/estoque")
                .bodyValue(mapDetalheToEstoqueRequest(pedido.getDetalhes()))
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if (result) repository.save(pedido);
        else throw new IllegalArgumentException("Can't save products list. At least one product not in stock");
        log.info("Pedido {} salvo com sucesso", pedido);
    }


    private List<EstoqueRequest> mapDetalheToEstoqueRequest(List<Detalhe> detalhes) {

        return detalhes.stream().map(detalhe -> EstoqueRequest
                        .builder()
                        .quantidade(detalhe.getQuantidade())
                        .nomeProduto(detalhe.getNomeProduto())
                        .build()
                )
                .toList();
    }

    private List<Detalhe> mapDetalheRequestToDetalhe(List<DetalheRequest> detalhes) {

        return detalhes.stream().map(detalhe -> Detalhe
                        .builder()
                        .quantidade(detalhe.getQuantidade())
                        .nomeProduto(detalhe.getNomeProduto())
                        .build()
                )
                .toList();
    }

}
