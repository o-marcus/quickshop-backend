package com.quickshop.productservice.repository;

import com.quickshop.productservice.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProdutoRepository extends MongoRepository<Produto, String> {

}
