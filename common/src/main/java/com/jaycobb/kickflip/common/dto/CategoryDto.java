package com.jaycobb.kickflip.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto extends BaseDto {

    private String name;

    private String description;

    public CategoryDto(final UUID id, final String name, final String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

}
