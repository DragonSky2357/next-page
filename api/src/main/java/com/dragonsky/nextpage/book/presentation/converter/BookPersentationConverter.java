package com.dragonsky.nextpage.book.presentation.converter;

import com.dragonsky.nextpage.book.application.dto.response.GetSearchBooksResult;
import com.dragonsky.nextpage.book.presentation.dto.response.GetSearchBooksApiResponse;
import org.springframework.stereotype.Component;

@Component
public class BookPersentationConverter {

    public GetSearchBooksApiResponse toResponse(GetSearchBooksResult result) {
        return GetSearchBooksApiResponse.from(result);
    }
}
