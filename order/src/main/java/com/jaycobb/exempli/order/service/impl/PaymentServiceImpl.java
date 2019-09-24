package com.jaycobb.kickflip.order.service.impl;

import com.jaycobb.kickflip.common.dto.PaymentDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.order.model.Payment;
import com.jaycobb.kickflip.order.repository.PaymentRepository;
import com.jaycobb.kickflip.order.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl extends AbstractService<Payment, PaymentDto, PaymentRepository> implements PaymentService {

    protected PaymentServiceImpl(final PaymentRepository repository) {
        super(Payment.class, repository);
    }

}
