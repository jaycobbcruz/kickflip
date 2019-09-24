package com.jaycobb.kickflip.customer.service.impl;

import com.jaycobb.kickflip.common.dto.CustomerDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.customer.model.Customer;
import com.jaycobb.kickflip.customer.repository.CustomerRepository;
import com.jaycobb.kickflip.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl extends AbstractService<Customer, CustomerDto, CustomerRepository> implements CustomerService {

    protected CustomerServiceImpl(final CustomerRepository repository) {
        super(Customer.class, repository);
    }

}
