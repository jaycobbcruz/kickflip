package com.jaycobb.kickflip.product.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.BrandDto;
import com.jaycobb.kickflip.common.util.Constants;
import com.jaycobb.kickflip.product.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/brands")
public class BrandApi extends AbstractApi<BrandDto, BrandService> {

    public BrandApi(final BrandService service) {
        super(service);
    }
}
