package com.dragonsky.nextpage.infra.auth.reader;

import com.dragonsky.nextpage.domain.auth.repository.reader.AuthReader;
import com.dragonsky.nextpage.domain.auth.vo.RefreshToken;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthReaderImpl implements AuthReader {

    private final RedisRepository redisRepository;
    private static final String REFRESH_TOKEN_KEY_PREFIX = "refresh_token:";

    @Override
    public RefreshToken findRefreshToken(long memberId) {
        String key = REFRESH_TOKEN_KEY_PREFIX + memberId;
        String token = String.valueOf(redisRepository.get(key, String.class));

        return Optional.ofNullable(token)
                .map(RefreshToken::new)
                .orElse(null);
    }
}
