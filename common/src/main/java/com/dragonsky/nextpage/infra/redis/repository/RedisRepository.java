package com.dragonsky.nextpage.infra.redis.repository;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;

/**
 * Redis 접근을 추상화한 Repository 인터페이스
 * - 다양한 자료구조(String, Hash, List, Set, Sorted Set, Counter) 지원
 * - TTL 적용 가능
 * - 역직렬화 시 Optional 반환
 */
public interface RedisRepository {

    /* ================== String ================== */

    /**
     * 단순 값 저장
     */
    void save(String key, Object value);

    /**
     * 값 저장 + TTL 적용
     */
    void save(String key, Object value, Duration ttl);

    /**
     * 단일 키 조회 후 지정 타입으로 반환
     */
    <T> Optional<T> get(String key, Class<T> clazz);

    /**
     * 단일 키 삭제
     */
    boolean delete(String key);

    /* ================== Hash ================== */

    /**
     * Hash에 값 저장 (TTL 없음)
     */
    void saveHash(String key, String hashKey, Object value);

    /**
     * Hash에 값 저장 + TTL 적용
     */
    void saveHash(String key, String hashKey, Object value, Duration ttl);

    /**
     * Hash 조회 후 지정 타입으로 반환
     */
    <T> Optional<T> getHash(String key, String hashKey, Class<T> clazz);

    /* ================== List ================== */

    void leftPush(String key, Object value);

    void leftPush(String key, Object value, Duration ttl);

    <T> Optional<T> leftPop(String key, Class<T> clazz);

    void rightPush(String key, Object value);

    void rightPush(String key, Object value, Duration ttl);

    <T> Optional<T> rightPop(String key, Class<T> clazz);

    /* ================== Set ================== */

    void addToSet(String key, Object value);

    void addToSet(String key, Object value, Duration ttl);

    <T> Set<T> getSet(String key, Class<T> clazz);

    void removeFromSet(String key, Object value);

    boolean isMemberOfSet(String key, Object value);

    /* ================== Sorted Set ================== */

    void saveSortedSet(String key, Object member, double score);

    void saveSortedSet(String key, Object member, double score, Duration ttl);

    <T> Set<T> getSortedSetByScore(String key, double minScore, double maxScore, Class<T> clazz);

    /* ================== Counter ================== */

    long increment(String key, long value);

    long decrement(String key, long value);
}