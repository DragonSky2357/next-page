package com.dragonsky.nextpage.infra.redis.repository;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;

/**
 * Redis 데이터 접근을 위한 공통 Repository 인터페이스.
 * 제네릭 없이 Object 타입으로 처리하며,
 * 저장 시 TTL(만료시간) 설정을 지원합니다.
 */
public interface RedisRepository {

    /**
     * 키에 값을 저장합니다. TTL은 설정하지 않습니다.
     *
     * @param key   저장할 Redis 키
     * @param value 저장할 값 (Object)
     */
    void save(String key, Object value);

    /**
     * 키에 값을 저장하며, TTL(만료시간)을 설정할 수 있습니다.
     *
     * @param key   저장할 Redis 키
     * @param value 저장할 값 (Object)
     * @param ttl   만료 시간 (Duration), null일 경우 만료시간 없음
     */
    void save(String key, Object value, Duration ttl);

    /**
     * 키로 값을 조회합니다.
     * 저장된 값이 요청한 타입과 일치하면 그대로 반환하며,
     * 그렇지 않으면 JSON 역직렬화를 수행합니다.
     *
     * @param key   조회할 Redis 키
     * @param clazz 반환할 객체 타입
     * @return 조회된 값 Optional
     */
    Optional<Object> get(String key, Class<?> clazz);

    /**
     * 키에 해당하는 값을 삭제합니다.
     *
     * @param key 삭제할 Redis 키
     * @return 삭제 성공 여부
     */
    boolean delete(String key);

    /**
     * 해시(Hash) 자료구조에 값을 저장합니다. TTL은 설정하지 않습니다.
     *
     * @param key     해시를 저장할 Redis 키
     * @param hashKey 해시 내 필드 키
     * @param value   저장할 값 (Object)
     */
    void saveHash(String key, String hashKey, Object value);

    /**
     * 해시(Hash) 자료구조에 값을 저장하며 TTL을 설정할 수 있습니다.
     *
     * @param key     해시를 저장할 Redis 키
     * @param hashKey 해시 내 필드 키
     * @param value   저장할 값 (Object)
     * @param ttl     만료 시간 (Duration), null일 경우 만료시간 없음
     */
    void saveHash(String key, String hashKey, Object value, Duration ttl);

    /**
     * 해시(Hash) 내에서 값을 조회합니다.
     *
     * @param key     해시가 저장된 Redis 키
     * @param hashKey 해시 내 필드 키
     * @param clazz   반환할 객체 타입
     * @return 조회된 값 Optional
     */
    Optional<Object> getHash(String key, String hashKey, Class<?> clazz);

    /**
     * 리스트 자료구조 왼쪽에 값을 추가합니다. TTL은 설정하지 않습니다.
     *
     * @param key   리스트를 저장할 Redis 키
     * @param value 추가할 값 (Object)
     */
    void leftPush(String key, Object value);

    /**
     * 리스트 자료구조 왼쪽에 값을 추가하며 TTL을 설정할 수 있습니다.
     *
     * @param key   리스트를 저장할 Redis 키
     * @param value 추가할 값 (Object)
     * @param ttl   만료 시간 (Duration), null일 경우 만료시간 없음
     */
    void leftPush(String key, Object value, Duration ttl);

    /**
     * 리스트 자료구조 왼쪽에서 값을 꺼내옵니다.
     *
     * @param key   리스트가 저장된 Redis 키
     * @param clazz 반환할 객체 타입
     * @return 꺼내온 값 Optional
     */
    Optional<Object> leftPop(String key, Class<?> clazz);

    /**
     * 리스트 자료구조 오른쪽에 값을 추가합니다. TTL은 설정하지 않습니다.
     *
     * @param key   리스트를 저장할 Redis 키
     * @param value 추가할 값 (Object)
     */
    void rightPush(String key, Object value);

    /**
     * 리스트 자료구조 오른쪽에 값을 추가하며 TTL을 설정할 수 있습니다.
     *
     * @param key   리스트를 저장할 Redis 키
     * @param value 추가할 값 (Object)
     * @param ttl   만료 시간 (Duration), null일 경우 만료시간 없음
     */
    void rightPush(String key, Object value, Duration ttl);

    /**
     * 리스트 자료구조 오른쪽에서 값을 꺼내옵니다.
     *
     * @param key   리스트가 저장된 Redis 키
     * @param clazz 반환할 객체 타입
     * @return 꺼내온 값 Optional
     */
    Optional<Object> rightPop(String key, Class<?> clazz);

    /**
     * Set 자료구조에 값을 추가합니다. TTL은 설정하지 않습니다.
     *
     * @param key   Set을 저장할 Redis 키
     * @param value 추가할 값 (Object)
     */
    void addToSet(String key, Object value);

    /**
     * Set 자료구조에 값을 추가하며 TTL을 설정할 수 있습니다.
     *
     * @param key   Set을 저장할 Redis 키
     * @param value 추가할 값 (Object)
     * @param ttl   만료 시간 (Duration), null일 경우 만료시간 없음
     */
    void addToSet(String key, Object value, Duration ttl);

    /**
     * Set 자료구조에서 모든 값을 조회합니다.
     *
     * @param key   Set이 저장된 Redis 키
     * @param clazz 반환할 객체 타입
     * @return 조회된 값들의 Set
     */
    Set<Object> getSet(String key, Class<?> clazz);

    /**
     * Sorted Set에 값을 점수와 함께 저장합니다. TTL은 설정하지 않습니다.
     *
     * @param key    Sorted Set을 저장할 Redis 키
     * @param member 저장할 멤버 (Object)
     * @param score  점수 (정렬 기준)
     */
    void saveSortedSet(String key, Object member, double score);

    /**
     * Sorted Set에 값을 점수와 함께 저장하며 TTL을 설정할 수 있습니다.
     *
     * @param key    Sorted Set을 저장할 Redis 키
     * @param member 저장할 멤버 (Object)
     * @param score  점수 (정렬 기준)
     * @param ttl    만료 시간 (Duration), null일 경우 만료시간 없음
     */
    void saveSortedSet(String key, Object member, double score, Duration ttl);

    /**
     * Sorted Set에서 특정 점수 범위에 해당하는 멤버들을 조회합니다.
     *
     * @param key      Sorted Set이 저장된 Redis 키
     * @param minScore 최소 점수
     * @param maxScore 최대 점수
     * @param clazz    반환할 객체 타입
     * @return 조회된 멤버들의 Set
     */
    Set<Object> getSortedSetByScore(String key, double minScore, double maxScore, Class<?> clazz);

    /**
     * 키에 저장된 값을 value 만큼 증가시킵니다.
     *
     * @param key 증가시킬 Redis 키
     * @return 증가된 값
     */
    long increment(String key, long value);

    /**
     * 키에 저장된 값을 value 만큼 감소시킵니다.
     *
     * @param key 증가시킬 Redis 키
     * @return 증가된 값
     */
    long decrement(String key, long value);
}