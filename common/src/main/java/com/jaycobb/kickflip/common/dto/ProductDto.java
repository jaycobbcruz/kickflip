package com.jaycobb.kickflip.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String status;
    private Integer salesCounter;
    private CategoryDto category;

    public ProductDto(
            final UUID id,
            final String name,
            final String description,
            final BigDecimal price,
            final Integer quantity,
            final String status,
            final Integer salesCounter,
            final CategoryDto category) {

        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.salesCounter = salesCounter;
        this.category = category;
    }
}
