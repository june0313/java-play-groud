package me.jun.sgt.service;

import lombok.RequiredArgsConstructor;
import me.jun.sgt.codegen.types.Product;
import me.jun.sgt.repository.Database;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final Database database;

    public Product getProduct(String productId) {
        return database.products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}
