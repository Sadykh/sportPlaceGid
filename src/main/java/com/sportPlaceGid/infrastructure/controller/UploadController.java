package com.sportPlaceGid.infrastructure.controller;

import com.sportPlaceGid.infrastructure.dto.files.FileImageDto;
import com.sportPlaceGid.infrastructure.service.FileImageService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

@RestController
@RequestMapping("/api/files")
public class UploadController {

    @Value("${upload.path}")
    private String uploadFolder;

    @Autowired
    private FileImageService fileImageService;

    List<String> allowExtensions = Arrays.asList("jpg", "png", "jpeg");

    @PostMapping("/upload")
    public FileImageDto multiFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        StringJoiner sj = new StringJoiner(" , ");
        try {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            if (!allowExtensions.contains(extension)) {
                throw new Exception("Not allowed");
            }
            String newFileName = DigestUtils.md5Hex(Instant.now().getEpochSecond() + file.getOriginalFilename()).toUpperCase() + "." + extension;
            Path path = Paths.get(uploadFolder + newFileName);
            Files.write(path, bytes);
            fileImageService.create(newFileName);
            sj.add(newFileName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String uploadedFileName = sj.toString();
        if (StringUtils.isEmpty(uploadedFileName)) {
            throw new Exception("File not save");
        }
        return new FileImageDto(uploadedFileName);
    }
}
