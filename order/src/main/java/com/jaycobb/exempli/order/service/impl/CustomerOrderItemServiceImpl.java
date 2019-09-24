package com.jaycobb.kickflip.order.service.impl;

import com.jaycobb.kickflip.common.dto.CustomerOrderItemDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.order.model.CustomerOrderItem;
import com.jaycobb.kickflip.order.repository.CustomerOrderItemRepository;
import com.jaycobb.kickflip.order.service.CustomerOrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerOrderItemServiceImpl
        extends AbstractService<CustomerOrderItem, CustomerOrderItemDto, CustomerOrderItemRepository>
        implements CustomerOrderItemService {

    protected CustomerOrderItemServiceImpl(final CustomerOrderItemRepository repository) {
        super(CustomerOrderItem.class, repository);
    }

}
