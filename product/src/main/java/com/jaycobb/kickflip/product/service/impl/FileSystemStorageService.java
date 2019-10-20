package com.jaycobb.kickflip.product.service.impl;

import com.jaycobb.kickflip.common.dto.AttachmentDto;
import com.jaycobb.kickflip.common.exception.NotFoundException;
import com.jaycobb.kickflip.product.service.AttachmentService;
import com.jaycobb.kickflip.product.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileSystemStorageService implements StorageService {

    private static final Logger log = LoggerFactory.getLogger(FileSystemStorageService.class);

    private final Path fileUploadFolder;
    private final AttachmentService attachmentService;

    public FileSystemStorageService(
            final FileStorageProperties fileStorageProperties,
            final AttachmentService attachmentService) {

        this.fileUploadFolder = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        this.attachmentService = attachmentService;
    }

    @Override
    public String store(final MultipartFile file, final String entityType, final UUID entityId) {

        final String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (file.isEmpty()) {
            throw new RuntimeException("Failed to store empty file " + filename);
        }
        try (final InputStream inputStream = file.getInputStream()) {
            final String savedFilename = entityId + "-" + filename;
            attachmentService.save(new AttachmentDto(null, entityType, entityId, savedFilename));
            Files.copy(inputStream, fileUploadFolder.resolve(savedFilename), StandardCopyOption.REPLACE_EXISTING);
            return savedFilename;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public Resource load(final String entityType, final UUID entityId) {
        return attachmentService.findBy(entityType, entityId)
                .map(attachment -> {
                    try {
                        final Path filePath = this.fileUploadFolder.resolve(attachment.getFilename()).normalize();
                        final Resource resource = new UrlResource(filePath.toUri());
                        if (resource.exists()) {
                            return resource;
                        } else {
                            throw new NotFoundException("File not found " + attachment.getFilename());
                        }
                    } catch (Exception ex) {
                        throw new NotFoundException("File not found " + attachment.getFilename(), ex);
                    }
                })
                .orElseThrow(() -> new NotFoundException("File with type '" + entityType + "' and id '" + entityId + "' not found"));
    }
}
