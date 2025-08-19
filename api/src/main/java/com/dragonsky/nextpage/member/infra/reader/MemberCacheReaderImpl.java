package com.dragonsky.nextpage.member.infra.reader;

import com.dragonsky.nextpage.member.domain.cache.MemberCache;
import com.dragonsky.nextpage.member.domain.repository.reader.MemberCacheReader;
import com.dragonsky.nextpage.member.infra.MemberCacheRepository;
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
