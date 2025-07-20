package com.dragonsky.nextpage.infrastructure.member.reader;

import com.dragonsky.nextpage.domain.member.cache.MemberCache;
import com.dragonsky.nextpage.domain.member.repository.reader.MemberCacheReader;
import com.dragonsky.nextpage.infrastructure.member.MemberCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberCacheReaderImpl implements MemberCacheReader {

    private final MemberCacheRepository memberCacheRepository;

    @Override
    public Optional<MemberCache> findCachedMemberById(Long id) {
        return memberCacheRepository.findAuthMember(id);
    }

    @Override
    public void saveCachedMember(MemberCache memberCache, Duration duration) {
        memberCacheRepository.saveAuthMember(memberCache, duration);
    }
}
