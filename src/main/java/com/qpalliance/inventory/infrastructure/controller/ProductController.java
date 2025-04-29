package com.qpalliance.inventory.infrastructure.controller;

import com.qpalliance.inventory.domain.model.Product;
import com.qpalliance.inventory.usecase.CreateProductUseCase;
import com.qpalliance.inventory.usecase.GetAllProductsUseCase;
import com.qpalliance.inventory.usecase.GetLowStockAlertsUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.qpalliance.inventory.infrastructure.controller.dto.ProductRequestDTO;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final GetLowStockAlertsUseCase getLowStockAlertsUseCase;

    public ProductController(
            CreateProductUseCase createProductUseCase,
            GetAllProductsUseCase getAllProductsUseCase,
            GetLowStockAlertsUseCase getLowStockAlertsUseCase
    ) {
        this.createProductUseCase = createProductUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
        this.getLowStockAlertsUseCase = getLowStockAlertsUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductRequestDTO dto) {
        Product product = new Product(
                null,
                dto.getName(),
                dto.getCode(),
                dto.getCurrentStock(),
                dto.getMinStock()
        );
        Product created = createProductUseCase.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(getAllProductsUseCase.getAllProducts());
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<Product>> getLowStockAlerts() {
        return ResponseEntity.ok(getLowStockAlertsUseCase.getLowStockProducts());
    }
}
