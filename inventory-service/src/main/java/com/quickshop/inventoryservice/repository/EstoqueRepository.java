package com.quickshop.inventoryservice.repository;

import com.quickshop.inventoryservice.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    List<Estoque> findByNomeProdutoIn(List<String> nomeProduto);
}
