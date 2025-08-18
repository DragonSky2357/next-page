package com.dragonsky.nextpage.presentation.book.dto.response;

import com.dragonsky.nextpage.application.book.dto.response.GetSearchBooksResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSearchBooksApiResponse {
    private final List<Item> items;
    private final String updatedAt;

    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Item {
        private final String title;
        private final String link;
        private final String image;
        private final String author;
        private final String price;
        private final String discount;
        private final String publisher;
        private final String pubdate;
        private final String isbn;
        private final String description;

        public static Item from(GetSearchBooksResult.Item source) {
            return Item.builder()
                    .title(source.getTitle())
                    .link(source.getLink())
                    .image(source.getImage())
                    .author(source.getAuthor())
                    .price(source.getPrice())
                    .discount(source.getDiscount())
                    .publisher(source.getPublisher())
                    .pubdate(source.getPubdate())
                    .isbn(source.getIsbn())
                    .description(source.getDescription())
                    .build();
        }
    }

    public static GetSearchBooksApiResponse from(GetSearchBooksResult result) {
        List<Item> mappedItems = result.getItems().stream()
                .map(Item::from)
                .toList();

        return GetSearchBooksApiResponse.builder()
                .items(mappedItems)
                .updatedAt(result.getUpdatedAt())
                .build();
    }
}
