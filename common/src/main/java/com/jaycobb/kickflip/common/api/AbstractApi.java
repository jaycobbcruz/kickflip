package com.jaycobb.kickflip.common.api;

import com.jaycobb.kickflip.common.dto.BaseDto;
import com.jaycobb.kickflip.common.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public abstract class AbstractApi<D extends BaseDto, S extends BaseService> {

    private final S service;

    @GetMapping
    public List<D> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public D find(@PathVariable("id") final UUID id) {
        return (D) service.find(id);
    }

    @PostMapping
    public D save(@RequestBody D d) {
        return (D) service.save(d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final UUID id) {
        service.delete(id);
    }

    S getService() {
        return service;
    }
}
