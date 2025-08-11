package com.dragonsky.nextpage.domain.member.entity;

import com.dragonsky.nextpage.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
        name = "member",
        indexes = {
                @Index(name = "idx_member_email", columnList = "email"),
                @Index(name = "idx_member_nickname", columnList = "nickname")
        }
)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Setter
    @Column(name = "profile_image_url", length = 255)
    private String profileImage;
}
