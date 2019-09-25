package com.jaycobb.kickflip.order.model;

import com.jaycobb.kickflip.common.dto.PaymentDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import com.jaycobb.kickflip.common.type.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Payment extends AbstractEntity<PaymentDto> {

    private static final long serialVersionUID = -8225578899934441445L;

    private String paypalPaymentId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(unique = true)
    private CustomerOrder customerOrder;

    @Override
    public PaymentDto map() {
        return new PaymentDto(
                getId(),
                paypalPaymentId,
                status.name(),
                customerOrder != null ? customerOrder.getId() : null
        );
    }
}
