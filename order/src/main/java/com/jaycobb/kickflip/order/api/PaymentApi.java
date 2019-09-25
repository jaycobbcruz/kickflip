package com.jaycobb.kickflip.order.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.PaymentDto;
import com.jaycobb.kickflip.common.util.Constants;
import com.jaycobb.kickflip.order.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/payments")
public class PaymentApi extends AbstractApi<PaymentDto, PaymentService> {

    public PaymentApi(final PaymentService service) {
        super(service);
    }
}
