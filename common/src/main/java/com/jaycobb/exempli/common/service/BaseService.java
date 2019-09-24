package com.jaycobb.kickflip.common.service;

import com.jaycobb.kickflip.common.dto.BaseDto;

import java.util.List;
import java.util.UUID;

public interface BaseService<D extends BaseDto> {

    List<D> findAll();

    D find(UUID id);

    D save(D e);

    void delete(UUID id);
}
