package com.jaycobb.kickflip.customer.repository;

import com.jaycobb.kickflip.common.type.CartStatus;
import com.jaycobb.kickflip.customer.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {

    List<Cart> findByStatus(CartStatus status);
    List<Cart> findByStatusAndCustomerId(CartStatus status, UUID customerId);
}
