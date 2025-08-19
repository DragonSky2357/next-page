package com.dragonsky.nextpage.member.infra;

import com.dragonsky.nextpage.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findByNickname(String email);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
}
