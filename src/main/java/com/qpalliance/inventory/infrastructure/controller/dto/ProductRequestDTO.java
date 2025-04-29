package com.qpalliance.inventory.infrastructure.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El código no puede estar vacío")
    private String code;

    @NotNull(message = "El stock actual es requerido")
    @Min(value = 0, message = "El stock actual no puede ser negativo")
    private Integer currentStock;

    @NotNull(message = "El stock mínimo es requerido")
    @Min(value = 0, message = "El stock mínimo no puede ser negativo")
    private Integer minStock;

    // Getters y setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Integer getCurrentStock() { return currentStock; }
    public void setCurrentStock(Integer currentStock) { this.currentStock = currentStock; }

    public Integer getMinStock() { return minStock; }
    public void setMinStock(Integer minStock) { this.minStock = minStock; }
}
