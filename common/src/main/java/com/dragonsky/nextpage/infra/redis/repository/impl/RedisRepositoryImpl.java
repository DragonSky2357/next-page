package com.dragonsky.nextpage.infra.redis.repository.impl;

import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class RedisRepositoryImpl implements RedisRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    /**
     * 키에 값을 저장합니다. TTL 없이 저장합니다.
     */
    @Override
    public void save(String key, Object value) {
        save(key, value, null);
    }

    /**
     * 키에 값을 저장하며, TTL(만료 시간)을 설정할 수 있습니다.
     *
     * @param ttl 만료 시간, null일 경우 만료 시간 없음
     */
    @Override
    public void save(String key, Object value, Duration ttl) {
        redisTemplate.opsForValue().set(key, value);
        if (ttl != null) {
            redisTemplate.expire(key, ttl);
        }
    }

    /**
     * 키로 값을 조회합니다.
     * 저장된 값이 요청한 타입과 일치하면 그대로 반환하고,
     * 그렇지 않으면 JSON 직렬화/역직렬화를 통해 객체로 변환 후 반환합니다.
     */
    @Override
    public Optional<Object> get(String key, Class<?> clazz) {
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj == null) return Optional.empty();

        try {
            if (clazz.isInstance(obj)) {
                return Optional.of(obj);
            }
            String json = objectMapper.writeValueAsString(obj);
            Object value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis 역직렬화 실패", e);
        }
    }

    /**
     * 키에 해당하는 값을 삭제합니다.
     * 삭제 성공 시 true 반환.
     */
    @Override
    public boolean delete(String key) {
        Boolean result = redisTemplate.delete(key);
        return Boolean.TRUE.equals(result);
    }

    /**
     * 해시(Hash) 자료구조에 값 저장 (TTL 없음).
     */
    @Override
    public void saveHash(String key, String hashKey, Object value) {
        saveHash(key, hashKey, value, null);
    }

    /**
     * 해시(Hash) 자료구조에 값 저장 및 TTL 설정 가능.
     */
    @Override
    public void saveHash(String key, String hashKey, Object value, Duration ttl) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        if (ttl != null) {
            redisTemplate.expire(key, ttl);
        }
    }

    /**
     * 해시(Hash)에서 값을 조회합니다.
     */
    @Override
    public Optional<Object> getHash(String key, String hashKey, Class<?> clazz) {
        Object obj = redisTemplate.opsForHash().get(key, hashKey);
        if (obj == null) return Optional.empty();

        try {
            if (clazz.isInstance(obj)) {
                return Optional.of(obj);
            }
            String json = objectMapper.writeValueAsString(obj);
            Object value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis Hash 역직렬화 실패", e);
        }
    }

    /**
     * 리스트 자료구조 왼쪽에 값 추가 (TTL 없음).
     */
    @Override
    public void leftPush(String key, Object value) {
        leftPush(key, value, null);
    }

    /**
     * 리스트 자료구조 왼쪽에 값 추가 및 TTL 설정 가능.
     */
    @Override
    public void leftPush(String key, Object value, Duration ttl) {
        redisTemplate.opsForList().leftPush(key, value);
        if (ttl != null) {
            redisTemplate.expire(key, ttl);
        }
    }

    /**
     * 리스트 자료구조 왼쪽에서 값 팝핑 및 타입 변환.
     */
    @Override
    public Optional<Object> leftPop(String key, Class<?> clazz) {
        Object obj = redisTemplate.opsForList().leftPop(key);
        if (obj == null) return Optional.empty();

        try {
            if (clazz.isInstance(obj)) {
                return Optional.of(obj);
            }
            String json = objectMapper.writeValueAsString(obj);
            Object value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis List leftPop 역직렬화 실패", e);
        }
    }

    /**
     * 리스트 자료구조 오른쪽에 값 추가 (TTL 없음).
     */
    @Override
    public void rightPush(String key, Object value) {
        rightPush(key, value, null);
    }

    /**
     * 리스트 자료구조 오른쪽에 값 추가 및 TTL 설정 가능.
     */
    @Override
    public void rightPush(String key, Object value, Duration ttl) {
        redisTemplate.opsForList().rightPush(key, value);
        if (ttl != null) {
            redisTemplate.expire(key, ttl);
        }
    }

    /**
     * 리스트 자료구조 오른쪽에서 값 팝핑 및 타입 변환.
     */
    @Override
    public Optional<Object> rightPop(String key, Class<?> clazz) {
        Object obj = redisTemplate.opsForList().rightPop(key);
        if (obj == null) return Optional.empty();

        try {
            if (clazz.isInstance(obj)) {
                return Optional.of(obj);
            }
            String json = objectMapper.writeValueAsString(obj);
            Object value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis List rightPop 역직렬화 실패", e);
        }
    }

    /**
     * Set 자료구조에 값 추가 (TTL 없음).
     */
    @Override
    public void addToSet(String key, Object value) {
        addToSet(key, value, null);
    }

    /**
     * Set 자료구조에 값 추가 및 TTL 설정 가능.
     */
    @Override
    public void addToSet(String key, Object value, Duration ttl) {
        redisTemplate.opsForSet().add(key, value);
        if (ttl != null) {
            redisTemplate.expire(key, ttl);
        }
    }

    /**
     * Set 자료구조에서 모든 값 조회 및 타입 변환.
     */
    @Override
    public Set<Object> getSet(String key, Class<?> clazz) {
        Set<Object> objSet = redisTemplate.opsForSet().members(key);
        if (objSet == null) return new HashSet<>();

        Set<Object> resultSet = new HashSet<>();
        for (Object obj : objSet) {
            try {
                if (clazz.isInstance(obj)) {
                    resultSet.add(obj);
                } else {
                    String json = objectMapper.writeValueAsString(obj);
                    Object value = objectMapper.readValue(json, clazz);
                    resultSet.add(value);
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Redis Set 역직렬화 실패", e);
            }
        }
        return resultSet;
    }

    /**
     * Sorted Set에 값과 점수 저장 (TTL 없음).
     */
    @Override
    public void saveSortedSet(String key, Object member, double score) {
        saveSortedSet(key, member, score, null);
    }

    /**
     * Sorted Set에 값과 점수 저장 및 TTL 설정 가능.
     */
    @Override
    public void saveSortedSet(String key, Object member, double score, Duration ttl) {
        redisTemplate.opsForZSet().add(key, member, score);
        if (ttl != null) {
            redisTemplate.expire(key, ttl);
        }
    }

    /**
     * Sorted Set 범위 조회 후 타입 변환.
     */
    @Override
    public Set<Object> getSortedSetByScore(String key, double minScore, double maxScore, Class<?> clazz) {
        Set<Object> objSet = redisTemplate.opsForZSet().rangeByScore(key, minScore, maxScore);
        if (objSet == null) return new HashSet<>();

        Set<Object> resultSet = new HashSet<>();
        for (Object obj : objSet) {
            try {
                if (clazz.isInstance(obj)) {
                    resultSet.add(obj);
                } else {
                    String json = objectMapper.writeValueAsString(obj);
                    Object value = objectMapper.readValue(json, clazz);
                    resultSet.add(value);
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Redis SortedSet 역직렬화 실패", e);
            }
        }
        return resultSet;
    }

    @Override
    public long increment(String key, long value) {
        Long result = redisTemplate.opsForValue().increment(key, value);
        return result != null ? result : 0L;
    }

    @Override
    public long decrement(String key, long value) {
        Long result = redisTemplate.opsForValue().decrement(key, value);
        return result != null ? result : 0L;
    }
}