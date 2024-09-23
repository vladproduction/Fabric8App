package com.vladproduction.fabric8app.service.impl;

import com.vladproduction.fabric8app.dto.ProductDto;
import com.vladproduction.fabric8app.exceptions.ProductIsNotFoundException;
import com.vladproduction.fabric8app.mapper.AutoProductMapper;
import com.vladproduction.fabric8app.model.Product;
import com.vladproduction.fabric8app.repository.ProductRepository;
import com.vladproduction.fabric8app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = AutoProductMapper.MAPPER.mapToProduct(productDto);
        Product saved = productRepository.save(product);
        return AutoProductMapper.MAPPER.mapToProductDto(saved);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductIsNotFoundException("Product with ID " + productId + " does not found."));
        return AutoProductMapper.MAPPER.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(AutoProductMapper.MAPPER::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new ProductIsNotFoundException("Product with ID " + productDto.getId() + " does not found."));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        Product updatedProduct = productRepository.save(product);
        return AutoProductMapper.MAPPER.mapToProductDto(updatedProduct);
    }

    @Override
    public ProductDto updatePartialProduct(Long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductIsNotFoundException("Product with ID " + productId + " does not found."));
        if(productDto.getName() != null){
            product.setName(productDto.getName());
        }
        if(productDto.getPrice() != 0){
            product.setPrice(productDto.getPrice());
        }
        Product updated = productRepository.save(product);
        return AutoProductMapper.MAPPER.mapToProductDto(updated);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductIsNotFoundException("Product with ID " + productId + " does not found."));
        productRepository.deleteById(product.getId());
    }
}
