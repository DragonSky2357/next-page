package com.dragonsky.nextpage.domain.member.repository.reader;

import com.dragonsky.nextpage.domain.member.entity.Member;

import java.util.Optional;

public interface MemberReader {
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByNickname(String nickname);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
