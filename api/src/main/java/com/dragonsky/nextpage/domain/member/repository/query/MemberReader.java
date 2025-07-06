package com.dragonsky.nextpage.domain.member.repository.query;

import com.dragonsky.nextpage.domain.member.entity.Member;

import java.util.Optional;

public interface MemberReader {
    Optional<Member> findByEmail(String email);
    Optional<Member> findById(Long id);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
