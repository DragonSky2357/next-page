package com.dragonsky.nextpage.infra.redis.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
public class RedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, String value, Duration ttl) {
        if (ttl != null) {
            redisTemplate.opsForValue().set(key, value, ttl);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public boolean delete(String key){
        return redisTemplate.delete(key);
    }

    public void saveHash(String key, String hashKey, String value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public void saveHash(String key, String hashKey, String value, Duration ttl) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        redisTemplate.expire(key, ttl);
    }

    public void leftPush(String key, String value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public void leftPush(String key, String value, Duration ttl) {
        redisTemplate.opsForList().leftPush(key, value);
        redisTemplate.expire(key, ttl);
    }

    public void rightPush(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    public void rightPush(String key, String value, Duration ttl) {
        redisTemplate.opsForList().rightPush(key, value);
        redisTemplate.expire(key, ttl);
    }

    public void saveSet(String key, String member) {
        redisTemplate.opsForSet().add(key, member);
    }

    public void saveSet(String key, String member, Duration ttl) {
        redisTemplate.opsForSet().add(key, member);
        redisTemplate.expire(key, ttl);
    }

    public void saveSortedSet(String key, String member, double score) {
        redisTemplate.opsForZSet().add(key, member, score);
    }

    public void saveSortedSet(String key, String member, double score, Duration ttl) {
        redisTemplate.opsForZSet().add(key, member, score);
        redisTemplate.expire(key, ttl);
    }
}
