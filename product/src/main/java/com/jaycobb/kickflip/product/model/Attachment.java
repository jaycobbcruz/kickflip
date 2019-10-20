package com.jaycobb.kickflip.product.model;

import com.jaycobb.kickflip.common.dto.AttachmentDto;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Attachment extends AbstractEntity<AttachmentDto> {

    private String filename;
    private String entityType;

    @Column(name = "entityId", columnDefinition = "BINARY(16)")
    private UUID entityId;

    @Override
    public AttachmentDto map() {
        return new AttachmentDto(getId(), entityType, entityId, filename);
    }
}
