package com.dragonsky.nextpage.member.domain.repository.store;

import com.dragonsky.nextpage.member.domain.entity.Member;

public interface MemberStore{
    Member save(Member member);
    void deleteById(Long id);
}