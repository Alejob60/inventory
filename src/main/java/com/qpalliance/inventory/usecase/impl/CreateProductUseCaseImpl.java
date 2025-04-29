package com.qpalliance.inventory.usecase.impl;

import com.qpalliance.inventory.domain.model.Product;
import com.qpalliance.inventory.domain.repository.ProductRepository;
import com.qpalliance.inventory.usecase.CreateProductUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getCurrentStock() < 0 || product.getMinStock() < 0) {
            throw new IllegalArgumentException("Stock values must be positive");
        }
        return productRepository.save(product);
    }
}
