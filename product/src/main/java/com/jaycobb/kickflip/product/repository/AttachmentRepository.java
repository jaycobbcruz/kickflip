package com.jaycobb.kickflip.product.repository;

import com.jaycobb.kickflip.product.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {

    Optional<Attachment> findFirstByEntityTypeAndEntityId(String entityType, UUID entityId);

}
