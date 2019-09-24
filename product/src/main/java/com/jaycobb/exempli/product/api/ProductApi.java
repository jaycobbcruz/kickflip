package com.jaycobb.kickflip.product.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.ProductDto;
import com.jaycobb.kickflip.product.service.ProductService;
import com.jaycobb.kickflip.common.util.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/products")
public class ProductApi extends AbstractApi<ProductDto, ProductService> {

    public ProductApi(final ProductService service) {
        super(service);
    }
}
