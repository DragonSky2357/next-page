package com.dragonsky.nextpage.domain.member.repository.command;

import com.dragonsky.nextpage.domain.member.entity.Member;

public interface MemberStore{
    Member save(Member member);
    void deleteById(Long id);
}