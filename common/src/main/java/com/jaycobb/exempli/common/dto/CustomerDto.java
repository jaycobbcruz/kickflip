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
public class CustomerDto extends BaseDto {

    @EntityField
    private String firstName;

    @EntityField
    private String lastName;

    @EntityField
    private String email;

    @EntityField
    private String telephone;

    public CustomerDto(
            final UUID id,
            final String firstName,
            final String lastName,
            final String email,
            final String telephone) {

        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
    }
}
