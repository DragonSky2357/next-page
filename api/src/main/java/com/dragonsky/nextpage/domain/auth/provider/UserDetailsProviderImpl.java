package com.dragonsky.nextpage.domain.auth.provider;

import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.config.security.auth.UserDetailsProvider;
import com.dragonsky.nextpage.domain.member.cache.MemberCache;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.exception.MemberErrorCode;
import com.dragonsky.nextpage.domain.member.exception.MemberException;
import com.dragonsky.nextpage.domain.member.repository.reader.MemberCacheReader;
import com.dragonsky.nextpage.domain.member.repository.reader.MemberReader;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;

@Component
public class UserDetailsProviderImpl implements UserDetailsProvider {

    private final MemberReader memberReader;
    private final MemberCacheReader memberCacheReader;

    public UserDetailsProviderImpl(MemberReader memberReader, MemberCacheReader memberCacheReader) {
        this.memberReader = memberReader;
        this.memberCacheReader = memberCacheReader;
    }

    @Override
    public UserDetails loadUserById(Long userId) {
        Optional<MemberCache> cachedMember = memberCacheReader.findCachedMemberById(userId);

        if (cachedMember.isPresent()) {
            MemberCache cache = cachedMember.get();

            return new AuthUser(
                    cache.id(),
                    cache.email()
            );
        }

        Member member = memberReader.findById(userId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        MemberCache memberCache = new MemberCache(
                member.getId(),
                member.getEmail()
        );
        memberCacheReader.saveCachedMember(memberCache, Duration.ofDays(1));

        return new AuthUser(
                member.getId(),
                member.getEmail()
        );
    }
}
