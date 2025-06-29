package com.dragonsky.nextpage.member.domain.repository.query;

import com.dragonsky.nextpage.member.domain.entity.Member;

import java.util.Optional;

public interface MemberQueryRepository {
    Optional<Member> findByEmail(String email);
    Optional<Member> findById(Long id);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
