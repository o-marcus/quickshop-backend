package com.quickshop.orderservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetalheRequest {
    private String nomeProduto;
    private int quantidade;
    private BigDecimal preco;
}
