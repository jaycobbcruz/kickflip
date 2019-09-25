package com.jaycobb.kickflip.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaycobb.kickflip.common.dto.BaseDto;
import com.jaycobb.kickflip.common.util.ObjectUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity<DTO extends BaseDto> implements Serializable {
    private static final long serialVersionUID = 6687200834525998536L;

    public abstract DTO map();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @CreatedDate
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    private Instant lastModifiedDate = Instant.now();

    @Override
    public String toString() {
        return ObjectUtils.objectToJson(this);
    }
}
