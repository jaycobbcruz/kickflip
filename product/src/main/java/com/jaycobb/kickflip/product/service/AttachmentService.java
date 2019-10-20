package com.jaycobb.kickflip.product.service;

import com.jaycobb.kickflip.common.dto.AttachmentDto;
import com.jaycobb.kickflip.common.service.BaseService;
import com.jaycobb.kickflip.product.model.Attachment;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentService extends BaseService<AttachmentDto> {

    Optional<Attachment> findBy(String entityName, UUID entityId);

}
