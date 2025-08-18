package com.dragonsky.nextpage.domain.book.service.impl;

import com.dragonsky.nextpage.domain.book.repository.reader.BookReader;
import com.dragonsky.nextpage.domain.book.repository.store.BookStore;
import com.dragonsky.nextpage.domain.book.service.BookService;
import com.dragonsky.nextpage.infra.book.naver.api.NaverApiClient;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookReader bookReader;
    private final BookStore bookStore;
    private final NaverApiClient naverApiClient;

    @Override
    public NaverBookResponse searchBooks(BookSearchCondition condition) {
        return bookReader.getCachedBooks(condition)
                .orElseGet(() -> fetchBooksIfNotCached(condition));
    }

    private NaverBookResponse fetchBooksIfNotCached(BookSearchCondition condition) {
        // 1. 네이버 API 호출
        NaverBookResponse fetchedBooks = naverApiClient.searchBooks(condition);

        // 2. 도서 항목중 description 100글자로 자르기
        truncateDescriptions(fetchedBooks.getItems(), 200);

        // 3. 캐시에 저장
        bookStore.saveCachedBooks(condition, fetchedBooks);

        return fetchedBooks;
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
