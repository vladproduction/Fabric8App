package com.vladproduction.fabric8app.mapper;

import com.vladproduction.fabric8app.dto.ProductDto;
import com.vladproduction.fabric8app.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoProductMapper {

    AutoProductMapper MAPPER = Mappers.getMapper(AutoProductMapper.class);

    ProductDto mapToProductDto(Product product);
    Product mapToProduct(ProductDto productDto);

}
