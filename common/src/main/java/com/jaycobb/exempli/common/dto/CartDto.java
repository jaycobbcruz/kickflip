package com.jaycobb.kickflip.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CartDto extends BaseDto {

    private UUID orderId;

    private CustomerDto customer;

    private String status;

    public CartDto(final UUID id, final UUID orderId, final CustomerDto customer, final String status) {
        super(id);
        this.orderId = orderId;
        this.customer = customer;
        this.status = status;
    }

}
