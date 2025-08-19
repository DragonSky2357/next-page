package com.dragonsky.nextpage.domain.book.converter;

import com.dragonsky.nextpage.domain.book.entity.Book;
import com.dragonsky.nextpage.domain.book.vo.BookItem;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookRssResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class BookConverter {

    public BookItem from(NaverBookResponse.Item item) {

        return BookItem.builder()
                .title(item.getTitle())
                .author(item.getAuthor())
                .link(item.getLink())
                .publisher(item.getPublisher())
                .pubdate(item.getPubdate())
                .isbn(item.getIsbn())
                .description(item.getDescription())
                .image(item.getImage())
                .price(item.getPrice())
                .discount(item.getDiscount())
                .build();
    }

    public BookItem from(NaverBookRssResponse.Item item) {

        return BookItem.builder()
                .title(item.getTitle())
                .author(item.getAuthor())
                .link(item.getLink())
                .publisher(item.getPublisher())
                .pubdate(item.getPubdate())
                .isbn(item.getIsbn())
                .description(item.getDescription())
                .image(item.getImage())
                .price(item.getDiscount())
                .discount(item.getDiscount())
                .build();
    }

    public Book from(BookItem item) {
        DateTimeFormatter pubDateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return Book.builder()
                .title(item.getTitle())
                .author(item.getAuthor())
                .link(item.getLink())
                .publisher(item.getPublisher())
                .pubDate(parsePubDate(item.getPubdate(), pubDateFormatter))
                .isbn(item.getIsbn())
                .description(item.getDescription())
                .image(item.getImage())
                .price(parseInteger(item.getPrice()))
                .discountPrice(parseInteger(item.getDiscount()))
                .build();
    }

    private LocalDate parsePubDate(String pubDate, DateTimeFormatter pubDateFormatter) {
        return Optional.ofNullable(pubDate)
                .filter(StringUtils::hasText)
                .map(date -> LocalDate.parse(date, pubDateFormatter))
                .orElse(null);
    }

    private Integer parseInteger(String value) {
        if (!StringUtils.hasText(value)) return null;
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
