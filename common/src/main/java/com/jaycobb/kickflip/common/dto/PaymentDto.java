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
public class PaymentDto extends BaseDto {

    private String paypalPaymentId;
    private String status;
    private UUID orderId;

    public PaymentDto(final UUID id, final String paypalPaymentId, final String status, final UUID orderId) {
        super(id);
        this.paypalPaymentId = paypalPaymentId;
        this.status = status;
        this.orderId = orderId;
    }
}
