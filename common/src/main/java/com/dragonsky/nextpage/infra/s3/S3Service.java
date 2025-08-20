package com.dragonsky.nextpage.infra.s3;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.dragonsky.nextpage.domain.entity.Image;
import com.dragonsky.nextpage.util.File.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    /**
     * S3에 파일 업로드
     */
    private Image uploadFile(String key, String targetType, Long targetId, MultipartFile file) {
        try {
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucket)
                            .key(key)
                            .contentType(file.getContentType())
                            .build(),
                    RequestBody.fromBytes(file.getBytes())
            );

            return Image.builder()
                    .targetType(targetType)
                    .targetId(targetId)
                    .url(key)
                    .originalName(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .size(file.getSize())
                    .build();

        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

    /**
     * S3 파일 다운로드
     */
    public byte[] downloadFile(String key) {
        ResponseBytes<GetObjectResponse> responseBytes = s3Client.getObject(
                GetObjectRequest.builder()
                        .bucket(bucket)
                        .key(key)
                        .build(),
                ResponseTransformer.toBytes()
        );
        return responseBytes.asByteArray();
    }

    /**
     * S3 파일 삭제
     */
    public void deleteFile(String key) {
        s3Client.deleteObject(DeleteObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build());
    }

    /**
     * 리뷰 이미지 업로드
     */
    public Image uploadImage(MultipartFile file, String targetType, Long targetId) {
        String key = generateKey(targetType, file.getOriginalFilename());
        return uploadFile(key, targetType, targetId, file);
    }

    /**
     * 리뷰용 key 생성
     */
    private String generateKey(String targetType, String filename) {
        String extension = FileUtils.getExtension(filename);
        return targetType + "/" + NanoIdUtils.randomNanoId() + extension;
    }
}
