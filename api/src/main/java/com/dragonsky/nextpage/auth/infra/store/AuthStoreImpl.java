package com.dragonsky.nextpage.auth.infra.store;

import com.dragonsky.nextpage.auth.domain.repository.store.AuthStore;
import com.dragonsky.nextpage.auth.domain.vo.RefreshToken;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class AuthStoreImpl implements AuthStore {

    private static final String KEY_PREFIX = "refresh_token:";

    private final RedisRepository redisRepository;

    @Override
    public void saveRefreshToken(long memberId, RefreshToken refreshToken) {
        String key = KEY_PREFIX + memberId;
        redisRepository.save(key, refreshToken.getToken(), Duration.ofDays(7));
    }

    @Override
    public boolean deleteRefreshToken(long memberId) {
        String key = KEY_PREFIX + memberId;
        return redisRepository.delete(key);
    }
}
