package com.jaycobb.kickflip.order.model;

import com.jaycobb.kickflip.common.dto.CustomerOrderItemDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(indexes = {
        @Index(name = "product_id_idx", columnList = "product_id")
})
public class CustomerOrderItem extends AbstractEntity<CustomerOrderItemDto> {

    private static final long serialVersionUID = 9021830388778489214L;

    @NotNull
    private Long quantity;

    @Column(name = "product_id")
    private UUID productId;

    @ManyToOne
    private CustomerOrder customerOrder;

    @Override
    public CustomerOrderItemDto map() {
        return new CustomerOrderItemDto(
                getId(),
                quantity,
                productId,
                customerOrder != null ? customerOrder.getId() : null
        );
    }
}
