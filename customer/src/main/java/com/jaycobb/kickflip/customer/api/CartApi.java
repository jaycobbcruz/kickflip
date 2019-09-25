package com.jaycobb.kickflip.customer.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.CartDto;
import com.jaycobb.kickflip.common.util.Constants;
import com.jaycobb.kickflip.customer.service.CartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/carts")
public class CartApi extends AbstractApi<CartDto, CartService> {

    public CartApi(final CartService cartService) {
        super(cartService);
    }
}
