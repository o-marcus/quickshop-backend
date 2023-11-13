package com.quickshop.inventoryservice.dto;

import com.quickshop.inventoryservice.model.Estoque;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EstoqueResponse {
    private String nomeProduto;
    Boolean isInEstoque;
}
