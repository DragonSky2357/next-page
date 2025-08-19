package com.dragonsky.nextpage.book.infra.jpa;

import com.dragonsky.nextpage.book.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}
