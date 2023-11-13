package com.quickshop.inventoryservice.service;

import com.quickshop.inventoryservice.dto.EstoqueRequest;
import com.quickshop.inventoryservice.dto.EstoqueResponse;
import com.quickshop.inventoryservice.model.Estoque;
import com.quickshop.inventoryservice.repository.EstoqueRepository;
import com.quickshop.inventoryservice.usecases.DecrementEstoqueUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class EstoqueService {

    private final EstoqueRepository repository;

    @Autowired
    private DecrementEstoqueUseCase getDecremented;

    public List<EstoqueResponse> isInEstoque(List<String> request) {
        return repository.findByNomeProdutoIn(request)
                .stream()
                .map(estoque -> EstoqueResponse.builder()
                        .nomeProduto(estoque.getNomeProduto())
                        .isInEstoque(estoque.getQuantidade() > 0)
                        .build()
                ).toList();
    }

    public void decrementEstoque(List<EstoqueRequest> request) throws IllegalArgumentException {
        List<Estoque> data = repository
                .findByNomeProdutoIn(request
                        .stream()
                        .map(EstoqueRequest::getNomeProduto)
                        .toList()
                );
        List<Estoque> decremented = getDecremented.decrementFrom(data, request);
        if (decremented.isEmpty()) {
            throw new IllegalArgumentException("Can't update quantity");
        }
        repository.saveAll(decremented);
    }

    public List<Estoque> getAlEstoque() {
        return repository.findAll();
    }
}
