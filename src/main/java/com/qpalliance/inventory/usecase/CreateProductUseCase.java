package com.qpalliance.inventory.usecase;

import com.qpalliance.inventory.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
