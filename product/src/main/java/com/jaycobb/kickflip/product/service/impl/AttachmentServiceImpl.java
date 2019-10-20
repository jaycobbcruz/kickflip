package com.jaycobb.kickflip.product.service.impl;

import com.jaycobb.kickflip.common.dto.AttachmentDto;
import com.jaycobb.kickflip.common.service.impl.AbstractService;
import com.jaycobb.kickflip.product.model.Attachment;
import com.jaycobb.kickflip.product.repository.AttachmentRepository;
import com.jaycobb.kickflip.product.service.AttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class AttachmentServiceImpl extends AbstractService<Attachment, AttachmentDto, AttachmentRepository> implements AttachmentService {

    protected AttachmentServiceImpl(final AttachmentRepository repository) {
        super(Attachment.class, repository);
    }

    @Override
    public Optional<Attachment> findBy(final String entityType, final UUID entityId) {
        return getRepository().findFirstByEntityTypeAndEntityId(entityType, entityId);
    }
}
