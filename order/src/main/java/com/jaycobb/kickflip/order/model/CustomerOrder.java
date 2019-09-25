package com.jaycobb.kickflip.order.model;

import com.jaycobb.kickflip.common.dto.CustomerOrderDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import com.jaycobb.kickflip.common.model.Address;
import com.jaycobb.kickflip.common.type.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(indexes = {
        @Index(name = "card_id_idx", columnList = "cart_id")
})
public class CustomerOrder extends AbstractEntity<CustomerOrderDto> {

    private static final long serialVersionUID = 5763471691787921950L;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private ZonedDateTime shipped;

    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    @Embedded
    private Address shipmentAddress;

    @Column(name = "cart_id")
    private UUID cartId;

    @Override
    public CustomerOrderDto map() {
        return new CustomerOrderDto(
                getId(),
                totalPrice,
                status.name(),
                shipped,
                payment != null ? payment.map() : null,
                shipmentAddress != null ? shipmentAddress.map() : null
        );
    }
}
