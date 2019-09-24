package com.jaycobb.kickflip.order.repository;

import com.jaycobb.kickflip.order.model.CustomerOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerOrderItemRepository extends JpaRepository<CustomerOrderItem, UUID> {
}
