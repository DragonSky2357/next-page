package com.dragonsky.nextpage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 이미지가 속한 타겟 예: 'review', 'book', 'user'
     */
    @Column(nullable = false, length = 50)
    private String targetType;

    /**
     * 타겟 엔티티 ID (리뷰 ID, 책 ID, 회원 ID 등)
     */
    @Column(nullable = false)
    private Long targetId;

    /**
     * 접근 가능한 URL
     */
    @Column(nullable = false, length = 500)
    private String url;

    /**
     * 업로드한 원본 파일 이름
     */
    @Column(length = 255)
    private String originalName;

    /**
     * MIME 타입
     */
    @Column(length = 100)
    private String contentType;

    /**
     * 파일 크기(byte)
     */
    private Long size;
}
