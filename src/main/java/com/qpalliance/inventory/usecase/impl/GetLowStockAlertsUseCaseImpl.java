package com.qpalliance.inventory.usecase.impl;

import com.qpalliance.inventory.domain.model.Product;
import com.qpalliance.inventory.domain.repository.ProductRepository;
import com.qpalliance.inventory.usecase.GetLowStockAlertsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetLowStockAlertsUseCaseImpl implements GetLowStockAlertsUseCase {

    private final ProductRepository productRepository;

    public GetLowStockAlertsUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getLowStockProducts() {
        return productRepository.findAllWithLowStock();
    }
}
