package com.jaycobb.kickflip.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomerOrderItemDto extends BaseDto {

    private Long quantity;
    private UUID productId;
    private UUID customerOrderId;

    public CustomerOrderItemDto(final UUID id, final Long quantity, final UUID productId, final UUID customerOrderId) {

        super(id);
        this.quantity = quantity;
        this.productId = productId;
        this.customerOrderId = customerOrderId;
    }
}
