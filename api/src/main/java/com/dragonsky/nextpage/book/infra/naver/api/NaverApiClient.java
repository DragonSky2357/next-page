package com.dragonsky.nextpage.book.infra.naver.api;

import com.dragonsky.nextpage.book.infra.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.book.infra.naver.dto.response.NaverBookRssResponse;
import com.dragonsky.nextpage.book.presentation.dto.request.BookSearchCondition;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

    private final WebClient webClient = WebClient.create();
    private final XmlMapper xmlMapper = new XmlMapper();

    public NaverBookResponse fetchBooks(BookSearchCondition condition) {
        return webClient.get()
                .uri("https://openapi.naver.com/v1/search/book.json?query={query}&start={start}&display={display}&sort={sort}",
                        condition.getQuery(), condition.getStart(), condition.getDisplay(), condition.getSort())
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .retrieve()
                .bodyToMono(NaverBookResponse.class)
                .block();
    }

    public NaverBookRssResponse fetchBookXml(String isbn) {
        String xml = webClient.get()
                .uri("https://openapi.naver.com/v1/search/book_adv.xml?d_isbn={isbn}", isbn)
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            return xmlMapper.readValue(xml, NaverBookRssResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
