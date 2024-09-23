package com.vladproduction.fabric8app.service;

import com.vladproduction.fabric8app.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(ProductDto productDto);
    ProductDto updatePartialProduct(Long productId, ProductDto productDto);
    void deleteProduct(Long productId);

}
