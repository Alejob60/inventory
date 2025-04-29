package com.qpalliance.inventory.domain.model;

import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private String code;
    private int currentStock;
    private int minStock;

    public Product(Long id, String name, String code, int currentStock, int minStock) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.currentStock = currentStock;
        this.minStock = minStock;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public int getCurrentStock() { return currentStock; }
    public int getMinStock() { return minStock; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setCurrentStock(int currentStock) { this.currentStock = currentStock; }
    public void setMinStock(int minStock) { this.minStock = minStock; }

    // Reglas básicas del dominio
    public boolean isLowStock() {
        return currentStock < minStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
}
