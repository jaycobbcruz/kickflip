package com.jaycobb.kickflip.common.service.impl;

import com.jaycobb.kickflip.common.dto.BaseDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import com.jaycobb.kickflip.common.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
@Slf4j
public abstract class AbstractService<E extends AbstractEntity, D extends BaseDto, Repo extends JpaRepository<E, UUID>> {

    private final Repo repository;
    private final Class<E> entityClass;

    protected AbstractService(final Class<E> entityClass, final Repo repository) {
        this.entityClass = entityClass;
        this.repository = repository;
    }

    public List<D> findAll() {

        final List<E> all = repository.findAll();
        return all.stream().map(e -> (D) e.map()).collect(Collectors.toList());
    }

    public D find(UUID id) {
        return (D) repository.findById(id).map(AbstractEntity::map).orElse(null);
    }

    public D save(D d) {
        log.info("Saving " + d);
        final E entity = toModel(d);
        ObjectUtils.populateEntity(d, entity);
        final E saved = repository.save(entity);
        return (D) saved.map();
    }

    public void delete(UUID id) {
        log.info("Deleting " + this.getClass().getSimpleName() + " with ID" + id);
        repository.deleteById(id);
    }

    private E toModel(D dto) {

        try {
            return dto.getId() != null ? repository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Invalid ID")) : entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
