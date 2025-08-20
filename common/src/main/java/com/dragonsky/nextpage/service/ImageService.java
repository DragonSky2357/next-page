package com.dragonsky.nextpage.service;

import com.dragonsky.nextpage.domain.entity.Image;
import com.dragonsky.nextpage.infra.s3.S3Service;
import com.dragonsky.nextpage.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {

    private final S3Service s3Service;
    private final ImageRepository imageRepository;

    public ImageService(S3Service s3Service, ImageRepository imageRepository) {
        this.s3Service = s3Service;
        this.imageRepository = imageRepository;
    }

    /**
     * 단일 파일 업로드 + DB 저장
     */
    public Image uploadImage(MultipartFile file, String targetType, Long targetId) {
        if (file == null || file.isEmpty()) return null;

        Image image = s3Service.uploadImage(file, targetType, targetId);

        if (image != null) {
            imageRepository.save(image);
        }

        return image;
    }

    /**
     * 여러 파일 업로드 + DB 저장
     */
    public List<Image> uploadImages(List<MultipartFile> files, String targetType, Long targetId) {
        if (files == null || files.isEmpty()) return Collections.emptyList();

        List<Image> images = files.stream()
                .map(file -> uploadImage(file, targetType, targetId)) // 단일 업로드 메서드 재사용
                .filter(Objects::nonNull)
                .toList();

        imageRepository.saveAll(images);

        return images;
    }
}
