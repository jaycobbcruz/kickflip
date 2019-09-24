package com.jaycobb.kickflip.product.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.ReviewDto;
import com.jaycobb.kickflip.product.service.ReviewService;
import com.jaycobb.kickflip.common.util.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/reviews")
public class ReviewApi extends AbstractApi<ReviewDto, ReviewService> {

    public ReviewApi(final ReviewService service) {
        super(service);
    }
}
