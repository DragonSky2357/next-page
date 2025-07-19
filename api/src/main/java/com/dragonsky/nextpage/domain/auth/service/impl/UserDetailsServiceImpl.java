package com.dragonsky.nextpage.domain.auth.service.impl;

import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.repository.reader.MemberReader;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberReader memberReader;

    public UserDetailsServiceImpl(MemberReader memberReader) {
        this.memberReader = memberReader;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Member member = memberReader.findById(Long.valueOf(memberId))
                .orElseThrow(() -> new UsernameNotFoundException("Member not found with id: " + memberId));

        return new CustomUserDetails(member);
    }
}
