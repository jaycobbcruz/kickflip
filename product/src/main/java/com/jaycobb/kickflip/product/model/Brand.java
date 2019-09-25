package com.jaycobb.kickflip.product.model;

import com.jaycobb.kickflip.common.dto.BrandDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Brand extends AbstractEntity<BrandDto> {

    private String name;
    private String description;

    @Override
    public BrandDto map() {
        return new BrandDto(getId(), name, description);
    }
}
