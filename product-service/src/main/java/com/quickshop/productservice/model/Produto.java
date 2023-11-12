package com.quickshop.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(value = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Produto {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
