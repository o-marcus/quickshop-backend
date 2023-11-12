package com.quickshop.productservice.service;

import com.quickshop.productservice.dto.ProdutoRequest;
import com.quickshop.productservice.dto.ProdutoResponse;
import com.quickshop.productservice.model.Produto;
import com.quickshop.productservice.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ProdutoService {

    private final ProdutoRepository repository;

    public void createProduto(ProdutoRequest request) {

        Produto produto = Produto.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .preco(request.getPreco())
                .build();

        repository.save(produto);
        log.info("Produto {} salvo", produto);
    }

    public List<ProdutoResponse> getAllProdutos() {
        return repository.findAll().stream().map(this::mapToResponse).toList();
    }

    private ProdutoResponse mapToResponse(Produto produto) {
        return ProdutoResponse.builder()
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .descricao(produto.getDescricao())
                .build();
    }

}
