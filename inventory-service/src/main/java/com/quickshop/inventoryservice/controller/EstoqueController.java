package com.quickshop.inventoryservice.controller;

import com.quickshop.inventoryservice.dto.EstoqueRequest;
import com.quickshop.inventoryservice.dto.EstoqueResponse;
import com.quickshop.inventoryservice.model.Estoque;
import com.quickshop.inventoryservice.service.EstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estoque")
@AllArgsConstructor
public class EstoqueController {

    private final EstoqueService service;

    @GetMapping
    @RequestMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public List<EstoqueResponse> getEstoqueAvailable(@RequestParam List<String> codigo) {
        return service.isInEstoque(codigo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estoque> getAllEstoque() {
        return service.getAlEstoque();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Boolean updateEstoque(@RequestBody List<EstoqueRequest> request) {
        try {
            service.decrementEstoque(request);
            return true;
        }
        catch (IllegalArgumentException exception) {
            return false;
        }
    }

}
