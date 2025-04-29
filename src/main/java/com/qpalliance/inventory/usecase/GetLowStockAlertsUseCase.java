package com.qpalliance.inventory.usecase;

import com.qpalliance.inventory.domain.model.Product;

import java.util.List;

public interface GetLowStockAlertsUseCase {
    List<Product> getLowStockProducts();
}
