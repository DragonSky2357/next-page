package com.dragonsky.nextpage.infra.book.jpa;

import com.dragonsky.nextpage.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}
