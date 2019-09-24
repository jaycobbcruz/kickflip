package com.jaycobb.kickflip.product.model;

import com.jaycobb.kickflip.common.dto.ReviewDto;
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
public class Review extends AbstractEntity<ReviewDto> {

    private static final long serialVersionUID = 1824631931131393452L;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Long rating;

    @Override
    public ReviewDto map() {
        return new ReviewDto(
                getId(),
                title,
                description,
                rating
        );
    }
}
