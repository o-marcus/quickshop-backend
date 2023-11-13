package com.quickshop.inventoryservice.usecases;

import com.quickshop.inventoryservice.dto.EstoqueRequest;
import com.quickshop.inventoryservice.dto.EstoqueResponse;
import com.quickshop.inventoryservice.model.Estoque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecrementEstoqueUseCaseImpl implements DecrementEstoqueUseCase {
    @Override
    public List<Estoque> decrementFrom(List<Estoque> data, List<EstoqueRequest> requests) {
        if (data.size() != requests.size()) return Collections.emptyList();
        int operations = 0;
        for (Estoque actual : data) {
            for (EstoqueRequest request : requests) {
                if (canDecrement(actual, request)) {
                    actual.setQuantidade(actual.getQuantidade() - request.getQuantidade());
                    operations++;
                }
            }
        }
        return data.size() == operations ? data : Collections.emptyList();
    }

    private boolean canDecrement(Estoque actual, EstoqueRequest current) {
        return actual.getNomeProduto().equals(current.getNomeProduto()) && actual.getQuantidade() >= current.getQuantidade();
    }

}
