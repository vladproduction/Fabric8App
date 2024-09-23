package com.vladproduction.fabric8app.controller;

import com.vladproduction.fabric8app.dto.ProductDto;
import com.vladproduction.fabric8app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
        ProductDto productById = productService.getProductById(productId);
        return new ResponseEntity<>(productById, OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto){
        productDto.setId(productId);
        ProductDto updateProduct = productService.updateProduct(productDto);
        return new ResponseEntity<>(updateProduct, OK);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> updatePartially(@PathVariable Long productId, @RequestBody ProductDto productDto){
        ProductDto updatedPartialProduct = productService.updatePartialProduct(productId, productDto);
        return new ResponseEntity<>(updatedPartialProduct, OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product successfully deleted", HttpStatus.OK);
    }

}
