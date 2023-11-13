package com.quickshop.inventoryservice.usecases;

import com.quickshop.inventoryservice.dto.EstoqueRequest;
import com.quickshop.inventoryservice.dto.EstoqueResponse;
import com.quickshop.inventoryservice.model.Estoque;

import java.util.List;

public interface DecrementEstoqueUseCase  {

    List<Estoque> decrementFrom(List<Estoque> estoque, List<EstoqueRequest> responses);

}
