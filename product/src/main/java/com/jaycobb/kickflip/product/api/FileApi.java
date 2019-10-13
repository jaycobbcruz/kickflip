package com.jaycobb.kickflip.product.api;

import com.jaycobb.kickflip.common.util.Constants;
import com.jaycobb.kickflip.product.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(Constants.API + "/files")
public class FileApi {

    private final StorageService storageService;

    public FileApi(final StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public String upload(@RequestParam("file") final MultipartFile file) {

        storageService.store(file);
        return "Successful upload";
    }

}
