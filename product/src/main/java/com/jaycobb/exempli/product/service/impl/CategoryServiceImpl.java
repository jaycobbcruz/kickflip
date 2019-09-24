package com.jaycobb.kickflip.product.service.impl;

import com.jaycobb.kickflip.common.dto.CategoryDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.product.model.Category;
import com.jaycobb.kickflip.product.repository.CategoryRepository;
import com.jaycobb.kickflip.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl extends AbstractService<Category, CategoryDto, CategoryRepository> implements CategoryService {

    protected CategoryServiceImpl(final CategoryRepository repository) {
        super(Category.class, repository);
    }

}
