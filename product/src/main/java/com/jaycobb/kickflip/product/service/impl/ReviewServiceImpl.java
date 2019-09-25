package com.jaycobb.kickflip.product.service.impl;

import com.jaycobb.kickflip.common.dto.ReviewDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.product.model.Review;
import com.jaycobb.kickflip.product.repository.ReviewRepository;
import com.jaycobb.kickflip.product.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReviewServiceImpl extends AbstractService<Review, ReviewDto, ReviewRepository> implements ReviewService {

    protected ReviewServiceImpl(final ReviewRepository repository) {
        super(Review.class, repository);
    }

}
