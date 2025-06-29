package com.dragonsky.nextpage.core.common;

public interface Writer<T> {
    T save(T entity);
    void delete(T entity);
}
