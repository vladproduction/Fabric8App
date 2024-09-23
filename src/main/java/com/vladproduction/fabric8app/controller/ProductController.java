package com.vladproduction.fabric8app.controller;

import com.vladproduction.fabric8app.dto.ProductDto;
import com.vladproduction.fabric8app.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(
        name = "CRUD REST APIs: Product Controller",
        description = """
                CRUD REST API:\s
                POST: createProduct
                GET: getProductById
                GET: getAllProducts
                PUT: updateById
                PATCH: updatePartially
                DEL: deleteById"""
)
@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private ProductService productService;

    @Operation(
            summary = "[POST]: create Product REST API",
            description = "create Product REST API is used for save product in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, CREATED);
    }

    @Operation(
            summary = "[GET]: get Product REST API",
            description = "get Product by ID REST API is used for search product from a database by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
        ProductDto productById = productService.getProductById(productId);
        return new ResponseEntity<>(productById, OK);
    }

    @Operation(
            summary = "[GET]: get Products REST API",
            description = "get All Products REST API is used for get all products from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, OK);
    }

    @Operation(
            summary = "[PUT]: update Product REST API",
            description = "update Product REST API is used for change context of product (found by id) from candidate"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto){
        productDto.setId(productId);
        ProductDto updateProduct = productService.updateProduct(productDto);
        return new ResponseEntity<>(updateProduct, CREATED);
    }

    @Operation(
            summary = "[PATCH]: update Product REST API",
            description = "update Product REST API is used for change context partially of product (found by id) from candidate data (field/s update)"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> updatePartially(@PathVariable Long productId, @RequestBody ProductDto productDto){
        ProductDto updatedPartialProduct = productService.updatePartialProduct(productId, productDto);
        return new ResponseEntity<>(updatedPartialProduct, CREATED);
    }

    @Operation(
            summary = "[DELETE]: delete Product REST API",
            description = "delete Product REST API is used for search by id and remove product entity from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK (Product successfully deleted)"
    )
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("HTTP Status 200 OK (Product successfully deleted)", HttpStatus.OK);
    }

}
