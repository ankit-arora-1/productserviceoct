package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductDetails(Long id);
    public Product createProduct(String title, String description, String image, double price, String category);
    public List<Product> getAllProducts();
}
