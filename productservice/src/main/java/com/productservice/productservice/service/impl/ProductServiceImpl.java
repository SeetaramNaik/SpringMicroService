package com.productservice.productservice.service.impl;

import com.productservice.productservice.dto.ProductRequest;
import com.productservice.productservice.dto.ProductResponse;
import com.productservice.productservice.entity.Product;
import com.productservice.productservice.mapper.ProductMapper;
import com.productservice.productservice.repository.ProductRepository;
import com.productservice.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    @Override
    public ProductRequest createProduct(ProductRequest productRequest) {
        Product product = ProductMapper.mapToProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        log.info("Product {} is saved",product.getId());
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public List<ProductRequest> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductRequest mapToProductResponse(Product product) {
        return ProductMapper.mapToProductDto(product);
    }
}
