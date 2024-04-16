package com.productservice.productservice.controller;

import com.productservice.productservice.dto.ProductRequest;
import com.productservice.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;
    @PostMapping
    public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest productRequest){
        ProductRequest savedProduct = productService.createProduct(productRequest);
//        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ProductRequest>> getAllProducts(){
        List<ProductRequest> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


}
