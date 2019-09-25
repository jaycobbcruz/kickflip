package com.jaycobb.kickflip.order.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.CustomerOrderDto;
import com.jaycobb.kickflip.common.util.Constants;
import com.jaycobb.kickflip.order.service.CustomerOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/customer-orders")
public class CustomerOrderApi extends AbstractApi<CustomerOrderDto, CustomerOrderService> {

    public CustomerOrderApi(final CustomerOrderService service) {
        super(service);
    }
}
