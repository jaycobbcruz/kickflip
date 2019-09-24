package com.jaycobb.kickflip.customer.model;

import com.jaycobb.kickflip.common.dto.CartDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import com.jaycobb.kickflip.common.type.CartStatus;
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
@Table(
        indexes = {
        @Index(name = "customer_order_id_idx", columnList = "customer_order_id", unique = true)
})
public class Cart extends AbstractEntity<CartDto> {

    private static final long serialVersionUID = -5474223756616871593L;

    @Column(name = "customer_order_id")
    private UUID customerOrderId;

    @ManyToOne
    private Customer customer;

    @NotNull
    @Enumerated
    private CartStatus status;

    public Cart(final Customer customer) {
        this.customer = customer;
        this.status = CartStatus.NEW;
    }

    @Override
    public CartDto map() {
        return new CartDto(
                getId(),
                customerOrderId,
                customer.map(),
                status.name()
        );
    }
}
