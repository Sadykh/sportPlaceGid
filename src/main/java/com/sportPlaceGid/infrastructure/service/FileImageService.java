package com.sportPlaceGid.infrastructure.service;

import com.sportPlaceGid.domain.City;
import com.sportPlaceGid.domain.FileImage;
import com.sportPlaceGid.infrastructure.repository.FileImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileImageService {

    @Autowired
    private FileImageRepository fileImageRepository;

    public FileImage create(String name) {
        final FileImage fileImage = new FileImage(name);
        try {
            fileImageRepository.save(fileImage);
        } catch (final Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Файл возможно уже есть");
        }
        return fileImage;
    }

    public List<FileImage> getAll() {
        return fileImageRepository.findAll();
    }

    public FileImage getById(Long id) {
        return this.fileImageRepository.getOne(id);
    }

    public FileImage findByName(String name) {
        return this.fileImageRepository.findByName(name);
    }

}
