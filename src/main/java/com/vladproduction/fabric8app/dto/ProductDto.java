package com.vladproduction.fabric8app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "ProductDto (model info)")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    @Schema(description = "Product name")
    private String name;
    @Schema(description = "Product price")
    private double price;


}
