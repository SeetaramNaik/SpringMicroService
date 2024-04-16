package com.productservice.productservice.mapper;

import com.productservice.productservice.dto.ProductRequest;
import com.productservice.productservice.entity.Product;

public class ProductMapper {
    public static ProductRequest mapToProductDto(Product product){
        return new ProductRequest(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public static Product mapToProduct(ProductRequest productRequest){
        return new Product(
                productRequest.getId(),
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice()
        );
    }
}
