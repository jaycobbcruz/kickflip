package com.jaycobb.kickflip.product.model;

import com.jaycobb.kickflip.common.dto.ProductDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import com.jaycobb.kickflip.common.type.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Product extends AbstractEntity<ProductDto> {

    private static final long serialVersionUID = -3484376509352178917L;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal price;

    private Integer quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private Integer salesCounter;

    @ManyToOne
    private Category category;

    @Override
    public ProductDto map() {
        return new ProductDto(
                getId(),
                name,
                description,
                price,
                quantity,
                status.name(),
                salesCounter,
                category != null ? category.map() : null
        );
    }
}
