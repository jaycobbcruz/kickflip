package com.jaycobb.kickflip.customer.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.CustomerDto;
import com.jaycobb.kickflip.common.util.Constants;
import com.jaycobb.kickflip.customer.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/customers")
public class CustomerApi extends AbstractApi<CustomerDto, CustomerService> {

    public CustomerApi(final CustomerService service) {
        super(service);
    }
}
