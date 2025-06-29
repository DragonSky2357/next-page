package com.dragonsky.nextpage.core.common;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class ReaderImpl<T, ID> implements Reader<T, ID> {
    private final JpaRepository<T, ID> repository;
    private final Function<ID, RuntimeException> notFoundExceptionSupplier;

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> notFoundExceptionSupplier.apply(id));
    }
}
