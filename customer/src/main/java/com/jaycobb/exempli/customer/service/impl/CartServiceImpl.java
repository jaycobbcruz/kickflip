package com.jaycobb.kickflip.customer.service.impl;

import com.jaycobb.kickflip.common.dto.CartDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.customer.model.Cart;
import com.jaycobb.kickflip.customer.repository.CartRepository;
import com.jaycobb.kickflip.customer.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartServiceImpl extends AbstractService<Cart, CartDto, CartRepository> implements CartService {

    protected CartServiceImpl(final CartRepository repository) {
        super(Cart.class, repository);
    }

}
