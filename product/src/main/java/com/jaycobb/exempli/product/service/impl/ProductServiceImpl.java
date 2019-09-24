package com.jaycobb.kickflip.product.service.impl;

import com.jaycobb.kickflip.common.dto.ProductDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.product.model.Product;
import com.jaycobb.kickflip.product.repository.ProductRepository;
import com.jaycobb.kickflip.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl extends AbstractService<Product, ProductDto, ProductRepository> implements ProductService {

    protected ProductServiceImpl(final ProductRepository repository) {
        super(Product.class, repository);
    }

}
