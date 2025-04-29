package com.qpalliance.inventory.usecase.impl;

import com.qpalliance.inventory.domain.model.Product;
import com.qpalliance.inventory.domain.repository.ProductRepository;
import com.qpalliance.inventory.usecase.GetAllProductsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsUseCaseImpl implements GetAllProductsUseCase {

    private final ProductRepository productRepository;

    public GetAllProductsUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
