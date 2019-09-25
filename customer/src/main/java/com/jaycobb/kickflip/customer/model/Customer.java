package com.jaycobb.kickflip.customer.model;

import com.jaycobb.kickflip.common.dto.CustomerDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Customer extends AbstractEntity<CustomerDto> {

    private static final long serialVersionUID = -5234462812367728919L;

    private String firstName;

    private String lastName;

    private String email;

    private String telephone;

    @Override
    public CustomerDto map() {
        return new CustomerDto(
                getId(),
                firstName,
                lastName,
                email,
                telephone
        );
    }
}
