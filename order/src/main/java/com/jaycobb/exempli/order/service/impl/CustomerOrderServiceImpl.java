package com.jaycobb.kickflip.order.service.impl;

import com.jaycobb.kickflip.common.dto.CustomerOrderDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.order.model.CustomerOrder;
import com.jaycobb.kickflip.order.repository.CustomerOrderRepository;
import com.jaycobb.kickflip.order.service.CustomerOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerOrderServiceImpl extends AbstractService<CustomerOrder, CustomerOrderDto, CustomerOrderRepository> implements CustomerOrderService {

    protected CustomerOrderServiceImpl(final CustomerOrderRepository repository) {
        super(CustomerOrder.class, repository);
    }

}
