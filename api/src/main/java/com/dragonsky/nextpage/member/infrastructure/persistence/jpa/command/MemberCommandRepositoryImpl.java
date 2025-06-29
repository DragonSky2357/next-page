package com.dragonsky.nextpage.member.infrastructure.persistence.jpa.command;

import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.member.domain.repository.command.MemberCommandRepository;
import com.dragonsky.nextpage.member.infrastructure.persistence.jpa.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberCommandRepositoryImpl implements MemberCommandRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public void deleteById(Long id) {
        memberJpaRepository.deleteById(id);
    }
}
