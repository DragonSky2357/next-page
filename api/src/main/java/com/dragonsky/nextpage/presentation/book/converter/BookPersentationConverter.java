package com.dragonsky.nextpage.presentation.book.converter;

import com.dragonsky.nextpage.application.book.dto.response.GetSearchBooksResult;
import com.dragonsky.nextpage.presentation.book.dto.response.GetSearchBooksApiResponse;
import org.springframework.stereotype.Component;

@Component
public class BookPersentationConverter {

    public GetSearchBooksApiResponse toResponse(GetSearchBooksResult result) {
        return GetSearchBooksApiResponse.from(result);
    }
}
