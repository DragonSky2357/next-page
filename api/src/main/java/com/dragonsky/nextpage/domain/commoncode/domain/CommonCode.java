package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "common_code")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonCode extends BaseEntity {
    @Id
    @Column(length = 30)
    private String code; // 이 필드를 PK로 사용

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255)
    private String description;
}
