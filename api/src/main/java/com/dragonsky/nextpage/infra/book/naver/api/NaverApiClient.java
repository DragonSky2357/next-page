package com.dragonsky.nextpage.infra.book.naver.api;

import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class NaverApiClient {

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    private final WebClient webClient = WebClient.create("https://openapi.naver.com/v1/search/book.json");

    public NaverBookResponse searchBooks(BookSearchCondition condition) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", condition.getQuery())
                        .queryParam("start", condition.getStart())
                        .queryParam("display", condition.getDisplay())
                        .queryParam("sort",condition.getSort())
                        .build())
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .retrieve()
                .bodyToMono(NaverBookResponse.class)
                .block();
    }

}
