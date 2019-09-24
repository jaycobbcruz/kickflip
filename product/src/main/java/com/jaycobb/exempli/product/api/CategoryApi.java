package com.jaycobb.kickflip.product.api;

import com.jaycobb.kickflip.common.api.AbstractApi;
import com.jaycobb.kickflip.common.dto.CategoryDto;
import com.jaycobb.kickflip.product.service.CategoryService;
import com.jaycobb.kickflip.common.util.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API + "/categories")
public class CategoryApi extends AbstractApi<CategoryDto, CategoryService> {

    public CategoryApi(final CategoryService service) {
        super(service);
    }
}
