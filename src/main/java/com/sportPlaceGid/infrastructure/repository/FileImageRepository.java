package com.sportPlaceGid.infrastructure.repository;

import com.sportPlaceGid.domain.FileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileImageRepository extends JpaRepository<FileImage, Long> {

    FileImage findByName(String name);
}
