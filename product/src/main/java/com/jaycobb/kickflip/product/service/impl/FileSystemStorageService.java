package com.jaycobb.kickflip.product.service.impl;

import com.jaycobb.kickflip.product.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {

    private static final Logger log = LoggerFactory.getLogger(FileSystemStorageService.class);

    private final Path fileUploadFolder;

    public FileSystemStorageService(@Value("${file.upload.folder:/tmp/}") final String uploadFolder) {
        this.fileUploadFolder = Paths.get(uploadFolder);
    }

    @Override
    public void store(final MultipartFile file) {

        final String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (file.isEmpty()) {
            throw new RuntimeException("Failed to store empty file " + filename);
        }
        try (final InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, fileUploadFolder.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
