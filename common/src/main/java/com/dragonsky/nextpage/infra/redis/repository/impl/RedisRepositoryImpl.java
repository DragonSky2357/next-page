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
public class RedisRepositoryImpl<T> implements RedisRepository<T> {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void save(String key, T value) {
        save(key, value, null);
    }

    @Override
    public void save(String key, T value, Duration ttl) {
        try {
            String json = objectMapper.writeValueAsString(value);
            if (ttl != null) {
                redisTemplate.opsForValue().set(key, json, ttl);
            } else {
                redisTemplate.opsForValue().set(key, json);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis 저장 실패", e);
        }
    }

    @Override
    public Optional<T> get(String key, Class<T> clazz) {
        String json = redisTemplate.opsForValue().get(key);
        if (json == null) {
            return Optional.empty();
        }
        try {
            T value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis 역직렬화 실패", e);
        }
    }

    @Override
    public boolean delete(String key) {
        Boolean result = redisTemplate.delete(key);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public void saveHash(String key, String hashKey, T value) {
        saveHash(key, hashKey, value, null);
    }

    @Override
    public void saveHash(String key, String hashKey, T value, Duration ttl) {
        try {
            String json = objectMapper.writeValueAsString(value);
            redisTemplate.opsForHash().put(key, hashKey, json);
            if (ttl != null) {
                redisTemplate.expire(key, ttl);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis Hash 저장 실패", e);
        }
    }

    public Optional<T> getHash(String key, String hashKey, Class<T> clazz) {
        String json = (String) redisTemplate.opsForHash().get(key, hashKey);
        if (json == null) {
            return Optional.empty();
        }
        try {
            T value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis Hash 역직렬화 실패", e);
        }
    }

    @Override
    public void leftPush(String key, T value) {
        leftPush(key, value, null);
    }

    @Override
    public void leftPush(String key, T value, Duration ttl) {
        try {
            String json = objectMapper.writeValueAsString(value);
            redisTemplate.opsForList().leftPush(key, json);
            if (ttl != null) {
                redisTemplate.expire(key, ttl);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis List leftPush 실패", e);
        }
    }

    @Override
    public Optional<T> leftPop(String key, Class<T> clazz) {
        String json = redisTemplate.opsForList().leftPop(key);
        if (json == null) return Optional.empty();
        try {
            T value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis List leftPop 역직렬화 실패", e);
        }
    }

    @Override
    public void rightPush(String key, T value) {
        rightPush(key, value, null);
    }

    @Override
    public void rightPush(String key, T value, Duration ttl) {
        try {
            String json = objectMapper.writeValueAsString(value);
            redisTemplate.opsForList().rightPush(key, json);
            if (ttl != null) {
                redisTemplate.expire(key, ttl);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis List rightPush 실패", e);
        }
    }

    @Override
    public Optional<T> rightPop(String key, Class<T> clazz) {
        String json = redisTemplate.opsForList().rightPop(key);
        if (json == null) return Optional.empty();
        try {
            T value = objectMapper.readValue(json, clazz);
            return Optional.ofNullable(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis List rightPop 역직렬화 실패", e);
        }
    }

    @Override
    public void saveSet(String key, T member) {
        saveSet(key, member, null);
    }

    @Override
    public void saveSet(String key, T member, Duration ttl) {
        try {
            String json = objectMapper.writeValueAsString(member);
            redisTemplate.opsForSet().add(key, json);
            if (ttl != null) {
                redisTemplate.expire(key, ttl);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis Set 저장 실패", e);
        }
    }

    @Override
    public Set<T> getSet(String key, Class<T> clazz) {
        Set<String> jsonSet = redisTemplate.opsForSet().members(key);
        if (jsonSet == null) return new HashSet<>();

        Set<T> resultSet = new HashSet<>();
        for (String json : jsonSet) {
            try {
                T value = objectMapper.readValue(json, clazz);
                resultSet.add(value);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Redis Set 역직렬화 실패", e);
            }
        }
        return resultSet;
    }

    @Override
    public void saveSortedSet(String key, T member, double score) {
        saveSortedSet(key, member, score, null);
    }

    @Override
    public void saveSortedSet(String key, T member, double score, Duration ttl) {
        try {
            String json = objectMapper.writeValueAsString(member);
            redisTemplate.opsForZSet().add(key, json, score);
            if (ttl != null) {
                redisTemplate.expire(key, ttl);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Redis SortedSet 저장 실패", e);
        }
    }

    @Override
    public Set<T> getSortedSetByScore(String key, double minScore, double maxScore, Class<T> clazz) {
        Set<String> jsonSet = redisTemplate.opsForZSet().rangeByScore(key, minScore, maxScore);
        if (jsonSet == null) return new HashSet<>();

        Set<T> resultSet = new HashSet<>();
        for (String json : jsonSet) {
            try {
                T value = objectMapper.readValue(json, clazz);
                resultSet.add(value);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Redis SortedSet 역직렬화 실패", e);
            }
        }
        return resultSet;
    }
}
