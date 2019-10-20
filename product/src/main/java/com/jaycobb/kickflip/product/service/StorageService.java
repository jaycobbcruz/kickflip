package com.jaycobb.kickflip.product.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface StorageService {

    String store(MultipartFile file, String entityType, UUID entityId);

    Resource load(String entityType, UUID entityId);
}
