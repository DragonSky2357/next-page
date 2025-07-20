package com.dragonsky.nextpage.domain.member.repository.reader;

import com.dragonsky.nextpage.domain.member.cache.MemberCache;

import java.time.Duration;
import java.util.Optional;

public interface MemberCacheReader {
    Optional<MemberCache> findCachedMemberById(Long id);

    void saveCachedMember(MemberCache memberCache, Duration duration);
}

