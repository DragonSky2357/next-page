package com.dragonsky.nextpage.highlight.application;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.book.domain.service.BookService;
import com.dragonsky.nextpage.highlight.application.converter.HighlightConverter;
import com.dragonsky.nextpage.highlight.application.dto.input.CreateHighlightInput;
import com.dragonsky.nextpage.highlight.application.dto.result.CreateHighlightResult;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.highlight.domain.service.HighlightService;
import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.member.domain.service.MemberService;
import com.dragonsky.nextpage.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HighlightApplication {

    private final HighlightConverter highlightConverter;
    private final HighlightService highlightService;
    private final MemberService memberService;
    private final BookService bookService;
    private final ImageService imageService;

    @Transactional
    public CreateHighlightResult createHighlight(CreateHighlightInput input){
        // 1. 작성자 조회
        Member writer = memberService.getMemberById(input.writerId());

        // 2. 도서 조회 및 저장
        Book book = bookService.getBookByIsbn(input.isbn());

        // 3. 하이라이트 생성
        Highlight highlight = highlightService.createHighlight(writer, book, input);

        return highlightConverter.toCreateHighlightResult(highlight);
    }
}
