package com.quickshop.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quickshop.productservice.dto.ProdutoRequest;
import com.quickshop.productservice.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer container = new MongoDBContainer( "mongo:4.4.14-rc0-focal");
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		dymDynamicPropertyRegistry.add( "spring.data.mongodb.uri", container::getReplicaSetUrl);
	}

	@Autowired
	private ProdutoRepository repository;

	@Test
	void deve_cadastrar_produto() throws Exception {
		//	setup
		ProdutoRequest request = ProdutoRequest.builder()
				.nome("Galaxy pro")
				.descricao("Produto em ótimas condições")
				.preco(BigDecimal.valueOf(100.10))
				.build();

		String json = mapper.writeValueAsString(request);

		// act
		mvc
				.perform(post("/api/produto")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());

		//	assert
        Assertions.assertFalse(repository.findAll().isEmpty());
	}

}
