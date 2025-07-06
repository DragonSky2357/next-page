package com.dragonsky.nextpage.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "member_detail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberDetail {

    @Id
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "introduction", columnDefinition = "TEXT")
    private String introduction;

    @Column(name = "notify_comment", nullable = false)
    private boolean notifyComment = false;

    @Column(name = "notify_event", nullable = false)
    private boolean notifyEvent = false;

    @Column(name = "notify_email", nullable = false)
    private boolean notifyEmail = false;
}