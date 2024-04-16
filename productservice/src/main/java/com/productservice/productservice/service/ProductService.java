package com.productservice.productservice.service;

import com.productservice.productservice.dto.ProductRequest;

import java.util.List;

public interface ProductService {
    ProductRequest createProduct(ProductRequest productRequest);
    List<ProductRequest> getAllProducts();
}
