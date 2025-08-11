package com.dragonsky.nextpage.infra.member.store;

import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.repository.store.MemberStore;
import com.dragonsky.nextpage.infra.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {

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
