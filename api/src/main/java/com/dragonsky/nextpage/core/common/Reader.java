package com.dragonsky.nextpage.core.common;

import java.util.Optional;

public interface Reader<T, ID> {
    Optional<T> findById(ID id);
    T getById(ID id);
}