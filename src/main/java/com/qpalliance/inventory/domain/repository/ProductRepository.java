package com.qpalliance.inventory.domain.repository;

import com.qpalliance.inventory.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    List<Product> findAll();

    List<Product> findAllWithLowStock();

    Optional<Product> findById(Long id);
}
