package com.dragonsky.nextpage.infra.redis.repository.impl;

import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Redis 캐시 저장소 (Generic Repository)
 * - RedisTemplate을 직접 쓰는 대신, 도메인에서 재사용할 수 있도록 공통화
 * - 직렬화/역직렬화 처리 및 TTL 관리 캡슐화
 */

@Slf4j
@Repository
@RequiredArgsConstructor
public class RedisRepositoryImpl implements RedisRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    /* ================== 공통 헬퍼 ================== */

    /**
     * 객체를 지정한 타입으로 변환(Optional로 반환)
     * - obj가 null이면 Optional.empty()
     * - obj가 이미 clazz 타입이면 캐스팅 후 반환
     * - obj가 String이면 JSON 역직렬화
     * - 그 외 Object → JSON → clazz로 변환
     */

    private <T> Optional<T> convert(Object obj, Class<T> clazz) {
        if (obj == null) return Optional.empty();

        try {
            if (clazz.isInstance(obj)) {
                return Optional.of(clazz.cast(obj));
            }
            if (obj instanceof String json) {
                return Optional.of(objectMapper.readValue(json, clazz));
            }
            String json = objectMapper.writeValueAsString(obj);
            return Optional.of(objectMapper.readValue(json, clazz));
        } catch (Exception e) {
            log.warn("Redis 역직렬화 실패 obj={}, clazz={}", obj, clazz, e);
            return Optional.empty();
        }
    }

    /**
     * 단일 키에 값을 저장하면서 TTL 적용 가능
     */

    private void setWithTtl(String key, Object value, Duration ttl) {
        if (ttl != null) {
            redisTemplate.opsForValue().set(key, value, ttl);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * TTL이 존재하면 key에 대해 만료시간 설정
     */

    private void expireIfNeeded(String key, Duration ttl) {
        if (ttl != null) {
            redisTemplate.expire(key, ttl);
        }
    }

    /* ================== String ================== */

    @Override
    public void save(String key, Object value) {
        setWithTtl(key, value, null);
    }

    @Override
    public void save(String key, Object value, Duration ttl) {
        setWithTtl(key, value, ttl);
    }

    @Override
    public <T> Optional<T> get(String key, Class<T> clazz) {
        return convert(redisTemplate.opsForValue().get(key), clazz);
    }

    @Override
    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /* ================== Hash ================== */

    @Override
    public void saveHash(String key, String hashKey, Object value) {
        saveHash(key, hashKey, value, null);
    }

    @Override
    public void saveHash(String key, String hashKey, Object value, Duration ttl) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        expireIfNeeded(key, ttl);
    }

    @Override
    public <T> Optional<T> getHash(String key, String hashKey, Class<T> clazz) {
        return convert(redisTemplate.opsForHash().get(key, hashKey), clazz);
    }

    /* ================== List ================== */

    @Override
    public void leftPush(String key, Object value) {
        leftPush(key, value, null);
    }

    @Override
    public void leftPush(String key, Object value, Duration ttl) {
        redisTemplate.opsForList().leftPush(key, value);
        expireIfNeeded(key, ttl);
    }

    @Override
    public <T> Optional<T> leftPop(String key, Class<T> clazz) {
        return convert(redisTemplate.opsForList().leftPop(key), clazz);
    }

    @Override
    public void rightPush(String key, Object value) {
        rightPush(key, value, null);
    }

    @Override
    public void rightPush(String key, Object value, Duration ttl) {
        redisTemplate.opsForList().rightPush(key, value);
        expireIfNeeded(key, ttl);
    }

    @Override
    public <T> Optional<T> rightPop(String key, Class<T> clazz) {
        return convert(redisTemplate.opsForList().rightPop(key), clazz);
    }

    /* ================== Set ================== */

    @Override
    public void addToSet(String key, Object value) {
        addToSet(key, value, null);
    }

    @Override
    public void addToSet(String key, Object value, Duration ttl) {
        redisTemplate.opsForSet().add(key, value);
        expireIfNeeded(key, ttl);
    }

    @Override
    public <T> Set<T> getSet(String key, Class<T> clazz) {
        Set<Object> objSet = redisTemplate.opsForSet().members(key);
        if (objSet == null) return Set.of();
        return objSet.stream()
                .map(obj -> convert(obj, clazz).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    @Override
    public void removeFromSet(String key, Object value) {
        redisTemplate.opsForSet().remove(key, value);
    }

    @Override
    public boolean isMemberOfSet(String key, Object value) {
        return Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(key, value));
    }

    /* ================== Sorted Set ================== */

    @Override
    public void saveSortedSet(String key, Object member, double score) {
        saveSortedSet(key, member, score, null);
    }

    @Override
    public void saveSortedSet(String key, Object member, double score, Duration ttl) {
        redisTemplate.opsForZSet().add(key, member, score);
        expireIfNeeded(key, ttl);
    }

    @Override
    public <T> Set<T> getSortedSetByScore(String key, double minScore, double maxScore, Class<T> clazz) {
        Set<Object> objSet = redisTemplate.opsForZSet().rangeByScore(key, minScore, maxScore);
        if (objSet == null) return Set.of();
        return objSet.stream()
                .map(obj -> convert(obj, clazz).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    /* ================== Counter ================== */

    @Override
    public long increment(String key, long value) {
        return redisTemplate.opsForValue().increment(key, value);
    }

    @Override
    public long decrement(String key, long value) {
        return redisTemplate.opsForValue().decrement(key, value);
    }
}