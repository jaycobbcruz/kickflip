package com.jaycobb.kickflip.customer.repository;

import com.jaycobb.kickflip.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    // List<Customer> findAllByEnabled(Boolean enabled);

}
