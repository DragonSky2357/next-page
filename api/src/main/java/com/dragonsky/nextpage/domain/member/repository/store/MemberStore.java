package com.dragonsky.nextpage.domain.member.repository.store;

import com.dragonsky.nextpage.domain.member.entity.Member;

public interface MemberStore{
    Member save(Member member);
    void deleteById(Long id);
}