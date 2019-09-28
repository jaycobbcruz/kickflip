package com.jaycobb.kickflip.product.service.impl;

import com.jaycobb.kickflip.common.dto.BrandDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.product.model.Brand;
import com.jaycobb.kickflip.product.repository.BrandRepository;
import com.jaycobb.kickflip.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandServiceImpl extends AbstractService<Brand, BrandDto, BrandRepository> implements BrandService {

    protected BrandServiceImpl(final BrandRepository repository) {
        super(Brand.class, repository);
    }

}
