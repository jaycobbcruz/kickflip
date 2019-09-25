package com.jaycobb.kickflip.product.model;

import com.jaycobb.kickflip.common.dto.CategoryDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Category extends AbstractEntity<CategoryDto> {

    private static final long serialVersionUID = 7171293833433594419L;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @Override
    public CategoryDto map() {
        return new CategoryDto(
                getId(),
                name,
                description
        );
    }
}
