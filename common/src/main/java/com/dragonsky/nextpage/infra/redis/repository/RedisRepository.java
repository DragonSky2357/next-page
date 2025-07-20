package com.dragonsky.nextpage.infra.redis.repository;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;

public interface RedisRepository<T> {

    void save(String key, T value);

    void save(String key, T value, Duration ttl);

    Optional<T> get(String key, Class<T> clazz);

    boolean delete(String key);

    void saveHash(String key, String hashKey, T value);

    void saveHash(String key, String hashKey, T value, Duration ttl);

    Optional<T> getHash(String key, String hashKey, Class<T> clazz);

    void leftPush(String key, T value);

    void leftPush(String key, T value, Duration ttl);

    Optional<T> leftPop(String key, Class<T> clazz);

    void rightPush(String key, T value);

    void rightPush(String key, T value, Duration ttl);

    Optional<T> rightPop(String key, Class<T> clazz);

    void saveSet(String key, T member);

    void saveSet(String key, T member, Duration ttl);

    Set<T> getSet(String key, Class<T> clazz);

    void saveSortedSet(String key, T member, double score);

    void saveSortedSet(String key, T member, double score, Duration ttl);

    Set<T> getSortedSetByScore(String key, double minScore, double maxScore, Class<T> clazz);
}
