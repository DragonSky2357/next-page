package com.dragonsky.nextpage.domain.auth.service.impl;

import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.config.security.auth.UserDetailsProvider;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.exception.MemberErrorCode;
import com.dragonsky.nextpage.domain.member.exception.MemberException;
import com.dragonsky.nextpage.domain.member.repository.reader.MemberReader;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MemberDetailsProviderImpl implements UserDetailsProvider {

    private final MemberReader memberReader;

    public MemberDetailsProviderImpl(MemberReader memberReader) {
        this.memberReader = memberReader;
    }

    @Override
    public UserDetails loadUserById(Long userId) {
        Member member = memberReader.findById(userId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        return new AuthUser(
            member.getId(),
            member.getEmail(),
            member.getPassword()
        );
    }
}
