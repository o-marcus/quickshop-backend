package com.quickshop.orderservice.dto;

import com.quickshop.orderservice.model.Detalhe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PedidoRequest {
    private List<Detalhe> detalhes = new ArrayList<>();
}
