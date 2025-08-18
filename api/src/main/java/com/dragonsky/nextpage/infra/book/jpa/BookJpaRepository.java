package com.dragonsky.nextpage.infra.book.jpa;

import com.dragonsky.nextpage.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
