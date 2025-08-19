package com.dragonsky.nextpage.domain.book.service.impl;

import com.dragonsky.nextpage.domain.book.converter.BookConverter;
import com.dragonsky.nextpage.domain.book.entity.Book;
import com.dragonsky.nextpage.domain.book.exception.BookErrorCode;
import com.dragonsky.nextpage.domain.book.exception.BookException;
import com.dragonsky.nextpage.domain.book.repository.reader.BookReader;
import com.dragonsky.nextpage.domain.book.repository.store.BookStore;
import com.dragonsky.nextpage.domain.book.service.BookService;
import com.dragonsky.nextpage.domain.book.util.BookUtils;
import com.dragonsky.nextpage.domain.book.vo.BookItem;
import com.dragonsky.nextpage.infra.book.naver.api.NaverApiClient;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookRssResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookCacheRequest;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookConverter converter;
    private final BookReader bookReader;
    private final BookStore bookStore;
    private final NaverApiClient naverApiClient;

    @Override
    public NaverBookResponse searchBooks(BookSearchCondition condition) {
        return bookReader.getCachedSearchResults(condition)
                .orElseGet(() -> fetchBooksIfNotCached(condition));
    }

    @Override
    public Book createBook(Book book) {
        return bookReader.getBookByIsbn(book.getIsbn())
                .map(existing -> {
                    existing.setImage(book.getImage());
                    existing.setPrice(book.getPrice());
                    return bookStore.append(existing);
                })
                .orElseGet(() -> bookStore.append(book));
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        String normalizedIsbn = BookUtils.normalize(isbn);

        return bookReader.getCachedBookByIsbn(normalizedIsbn)
                .map(converter::from)
                .or(() -> bookReader.getBookByIsbn(normalizedIsbn))
                .or(() -> Optional.ofNullable(fetchBookIfNotCached(normalizedIsbn)))
                .orElseThrow(() -> new BookException(BookErrorCode.BOOK_NOT_FOUND));
    }

    @Override
    public void cacheBookItemByIsbn(BookCacheRequest request) {

        var condition = new BookSearchCondition(
                request.getQuery(),
                request.getStart(),
                request.getDisplay(),
                request.getSort()
        );

        // 1. 캐시에서 검색 조건으로 책 리스트 조회
        bookReader.getCachedSearchResults(condition)
                .ifPresent(response -> {
                    String normalizedIsbn = BookUtils.normalize(request.getIsbn());

                    // 2. ISBN 기준으로 Item 찾기
                    response.getItems().stream()
                            .filter(item -> normalizedIsbn.equals(BookUtils.normalize(item.getIsbn())))
                            .findFirst()
                            .map(converter::from)
                            .ifPresent(item -> bookStore.cacheBookByIsbn(normalizedIsbn, item));
                });
    }

    private NaverBookResponse fetchBooksIfNotCached(BookSearchCondition condition) {
        // 1. 네이버 API 호출
        NaverBookResponse fetchedBooks = naverApiClient.fetchBooks(condition);

        // 2. 도서 항목중 description 100글자로 자르기
        truncateDescriptions(fetchedBooks.getItems(), 200);

        // 3. 캐시에 저장
        bookStore.cacheBooks(condition, fetchedBooks);

        return fetchedBooks;
    }

    private Book fetchBookIfNotCached(String isbn) {
        // 1. 네이버 API(응답값: xml) 호출
        NaverBookRssResponse fetchedBook = naverApiClient.fetchBookXml(isbn);

        //2 Api 응답값 Book으로 변환
        BookItem bookItem = Optional.ofNullable(fetchedBook.getChannel())
                .map(NaverBookRssResponse.Channel::getItem)
                .filter(items -> !items.isEmpty())
                // ISBN이 고유하다는 가정하에 1개 조회
                .map(items -> items.get(0))
                .map(converter::from)
                .orElseThrow(() -> new BookException(BookErrorCode.BOOK_NOT_FOUND));

        // 2. 캐시에 저장
        bookStore.cacheBookByIsbn(isbn, bookItem);

        // 3. BookItem -> book 형태로 변환
        Book book = converter.from(bookItem);

        return book;
    }

    /**
     * Item 리스트의 description을 maxLength로 자르는 헬퍼 메서드
     */
    private void truncateDescriptions(List<NaverBookResponse.Item> items, int maxLength) {
        for (var item : items) {
            String desc = item.getDescription();
            if (desc != null && desc.length() > maxLength) {
                item.setDescription(desc.substring(0, maxLength));
            }
        }
    }
}
