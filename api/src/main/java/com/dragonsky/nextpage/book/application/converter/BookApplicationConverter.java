package com.dragonsky.nextpage.book.application.converter;

import com.dragonsky.nextpage.book.application.dto.response.GetSearchBooksResult;
import com.dragonsky.nextpage.book.infra.naver.dto.response.NaverBookResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class BookApplicationConverter {

    public GetSearchBooksResult toResult(NaverBookResponse response) {
        List<GetSearchBooksResult.Item> items = mapItems(response.getItems());

        return GetSearchBooksResult.builder()
                .items(items)
                .updatedAt(response.getLastBuildDate())
                .build();
    }

    private List<GetSearchBooksResult.Item> mapItems(List<NaverBookResponse.Item> responseItems) {
        if (responseItems == null) return Collections.emptyList();

        return responseItems.stream()
                .map(this::toItem)
                .toList();
    }

    private GetSearchBooksResult.Item toItem(NaverBookResponse.Item item) {
        return GetSearchBooksResult.Item.builder()
                .title(item.getTitle())
                .link(item.getLink())
                .image(item.getImage())
                .author(item.getAuthor())
                .price(item.getPrice())
                .discount(item.getDiscount())
                .publisher(item.getPublisher())
                .pubdate(item.getPubdate())
                .isbn(item.getIsbn())
                .description(item.getDescription())
                .build();
    }
}
