package com.dragonsky.nextpage.member.domain.repository.command;

import com.dragonsky.nextpage.member.domain.entity.Member;

public interface MemberCommandRepository{
    Member save(Member member);
    void deleteById(Long id);
}