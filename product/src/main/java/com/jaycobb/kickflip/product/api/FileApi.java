package com.jaycobb.kickflip.product.api;

import com.jaycobb.kickflip.common.util.Constants;
import com.jaycobb.kickflip.product.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping(Constants.API + "/files")
@Slf4j
public class FileApi {

    private final StorageService storageService;

    public FileApi(final StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/{entityType}/{entityId}")
    public String upload(
            @RequestParam("file") final MultipartFile file,
            @PathVariable("entityType") final String entityType,
            @PathVariable("entityId") final UUID entityId) {

        return storageService.store(file, entityType, entityId);
    }

    @GetMapping(value = "/{entityType}/{entityId}")
    public ResponseEntity<Resource> download(
            final HttpServletRequest request,
            @PathVariable("entityType") final String entityType,
            @PathVariable("entityId") final UUID entityId) {

        final Resource resource = storageService.load(entityType, entityId);
        String contentType = "application/octet-stream";
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            log.warn("Cound not determine resource type");
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
