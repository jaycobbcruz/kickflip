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
public class ReviewDto extends BaseDto {

    private String title;
    private String description;
    private Long rating;

    public ReviewDto(final UUID id, final String title, final String description, final Long rating) {

        super(id);
        this.title = title;
        this.description = description;
        this.rating = rating;
    }
}
