package com.qpalliance.inventory.infrastructure.persistence;

import com.qpalliance.inventory.domain.model.Product;
import com.qpalliance.inventory.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository jpaRepository;

    public ProductRepositoryImpl(ProductJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = toEntity(product);
        ProductEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    private Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getCode(),
                entity.getCurrentStock(),
                entity.getMinStock()
        );
    }

    private ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setCode(product.getCode());
        entity.setCurrentStock(product.getCurrentStock());
        entity.setMinStock(product.getMinStock());
        return entity;
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)    
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Product> findAllWithLowStock() {
        return jpaRepository.findAllWithLowStock().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}