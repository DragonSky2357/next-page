package com.dragonsky.nextpage.member.domain.repository.reader;

import com.dragonsky.nextpage.member.domain.cache.MemberCache;

import java.time.Duration;
import java.util.Optional;

public interface MemberCacheReader {
    Optional<MemberCache> findCachedMemberById(Long id);

    void saveCachedMember(MemberCache memberCache, Duration duration);
}

