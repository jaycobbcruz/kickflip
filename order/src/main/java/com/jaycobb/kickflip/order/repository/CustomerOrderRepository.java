package com.jaycobb.kickflip.order.repository;

import com.jaycobb.kickflip.order.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, UUID> {

    //List<CustomerOrder> findByCartCustomer_Id(UUID id);
}
