package com.jaycobb.kickflip.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDto extends BaseDto {

    private String entityType;
    private UUID entityId;
    private String filename;

    public AttachmentDto(final UUID id, final String entityType, final UUID entityId, final String filename) {
        super(id);
        this.entityType = entityType;
        this.entityId = entityId;
        this.filename = filename;
    }

}
