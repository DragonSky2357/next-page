package com.dragonsky.nextpage.infrastructure.member;

import com.dragonsky.nextpage.domain.member.cache.MemberCache;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

@Repository
public class MemberCacheRepository {

    private static final String AUTH_MEMBER_KEY_PREFIX = "auth:member:";

    private final RedisRepository redisRepository;

    public MemberCacheRepository(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    public void saveAuthMember(MemberCache memberCache, Duration duration) {
        String key = getKey(memberCache.id());
        redisRepository.save(key, memberCache, duration);
    }

    public Optional<MemberCache> findAuthMember(Long id) {
        String key = getKey(id);
        return redisRepository.get(key, MemberCache.class).map(obj -> (MemberCache) obj);
    }

    public void deleteById(Long id) {
        String key = getKey(id);
        redisRepository.delete(key);
    }

    private String getKey(Long memberId) {
        return AUTH_MEMBER_KEY_PREFIX + memberId;
    }
}
