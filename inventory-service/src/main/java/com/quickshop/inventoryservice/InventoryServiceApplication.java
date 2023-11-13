package com.quickshop.inventoryservice;

import com.quickshop.inventoryservice.model.Estoque;
import com.quickshop.inventoryservice.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

	@Autowired
	EstoqueRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Apenas para preencher a base de dados

//		repository.save(Estoque.builder().nomeProduto("iphone").quantidade(10).build());
//		repository.save(Estoque.builder().nomeProduto("televisao").quantidade(50).build());
//		repository.save(Estoque.builder().nomeProduto("maquina_de_lavar").quantidade(30).build());
//		repository.save(Estoque.builder().nomeProduto("geladeira").quantidade(0).build());
	}


}
