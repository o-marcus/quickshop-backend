package com.quickshop.productservice.controller;

import com.quickshop.productservice.dto.ProdutoRequest;
import com.quickshop.productservice.dto.ProdutoResponse;
import com.quickshop.productservice.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduto(@RequestBody ProdutoRequest request) {
        service.createProduto(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoResponse> getAllProdutos() {
        return service.getAllProdutos();
    }

}
