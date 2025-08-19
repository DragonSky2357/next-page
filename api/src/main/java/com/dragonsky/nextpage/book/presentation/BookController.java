package com.dragonsky.nextpage.book.presentation;

import com.dragonsky.nextpage.book.application.BookApplication;
import com.dragonsky.nextpage.book.presentation.converter.BookPersentationConverter;
import com.dragonsky.nextpage.book.presentation.dto.request.BookCacheRequest;
import com.dragonsky.nextpage.book.presentation.dto.request.BookSearchCondition;
import com.dragonsky.nextpage.book.presentation.dto.response.GetSearchBooksApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookPersentationConverter bookConverter;
    private final BookApplication bookApplication;

    @GetMapping()
    public ResponseEntity<GetSearchBooksApiResponse> getSearchBooks(
            BookSearchCondition condition
    ) {
        var result = bookApplication.searchBook(condition);
        var response = bookConverter.toResponse(result);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/cache")
    public ResponseEntity<String> cacheBook(
            @RequestBody BookCacheRequest request
    ) {
        bookApplication.cacheBookFromClient(request);
        return ResponseEntity.ok("Book cached successfully for ISBN: " + request.getIsbn());
    }
}
