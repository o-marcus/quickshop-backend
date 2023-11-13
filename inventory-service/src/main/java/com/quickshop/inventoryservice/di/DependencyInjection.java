package com.quickshop.inventoryservice.di;

import com.quickshop.inventoryservice.usecases.DecrementEstoqueUseCase;
import com.quickshop.inventoryservice.usecases.DecrementEstoqueUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {
    @Bean
    public DecrementEstoqueUseCase getDecrementUseCase() {
        return new DecrementEstoqueUseCaseImpl();
    }
}
