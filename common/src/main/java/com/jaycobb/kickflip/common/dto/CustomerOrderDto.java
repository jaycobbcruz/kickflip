package com.jaycobb.kickflip.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomerOrderDto extends BaseDto {

    private BigDecimal totalPrice;
    private String status;
    private ZonedDateTime shipped;
    private PaymentDto paymentDto;
    private AddressDto shipmentAddress;

    public CustomerOrderDto(
            final UUID id,
            final BigDecimal totalPrice,
            final String status,
            final ZonedDateTime shipped,
            final PaymentDto paymentDto,
            final AddressDto shipmentAddress) {

        super(id);
        this.totalPrice = totalPrice;
        this.status = status;
        this.shipped = shipped;
        this.paymentDto = paymentDto;
        this.shipmentAddress = shipmentAddress;
    }

}
