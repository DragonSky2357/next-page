package com.dragonsky.nextpage.domain.member.service.impl;

import com.dragonsky.nextpage.application.member.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.domain.member.converter.MemberConverter;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.exception.MemberErrorCode;
import com.dragonsky.nextpage.domain.member.exception.MemberException;
import com.dragonsky.nextpage.domain.member.repository.store.MemberStore;
import com.dragonsky.nextpage.domain.member.repository.reader.MemberReader;
import com.dragonsky.nextpage.domain.member.service.MemberService;
import com.dragonsky.nextpage.util.security.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.dragonsky.nextpage.domain.member.exception.MemberErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberConverter memberConverter;
    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final PasswordEncoderUtil passwordEncoderUtil;

    @Override
    public Long register(MemberRegistrationInput input) {
        validateDuplicate(input);

        Member member = createMember(input);
        return memberStore.save(member).getId();
    }

    @Override
    public Member getMemberByEmail(String email) {
        return findMember("email",email);
    }

    @Override
    public Member getMemberById(Long memberId) {
        return findMember("id", String.valueOf(memberId));
    }

    private void validateDuplicate(MemberRegistrationInput input) {
        validateDuplicateEmail(input.email());
        validateDuplicateNickname(input.nickname());
    }

    private void validateDuplicateEmail(String email) {
        if (memberReader.existsByEmail(email)) {
            throw new MemberException(MemberErrorCode.EMAIL_ALREADY_EXISTS);
        }
    }

    private void validateDuplicateNickname(String nickname) {
        if (memberReader.existsByNickname(nickname)) {
            throw new MemberException(MemberErrorCode.NICKNAME_ALREADY_EXISTS);
        }
    }

    private Member createMember(MemberRegistrationInput input) {
        String encodedPassword = passwordEncoderUtil.encode(input.password());

        Member member = memberConverter.toEntity(input, encodedPassword);
        member.setPassword(encodedPassword);

        return member;
    }

    private Member findMember(String searchType, String value){
        return switch (searchType) {
            case "id" -> memberReader.findById(Long.parseLong(value))
                    .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
            case "email" -> memberReader.findByEmail(value)
                    .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
            case "nickname" -> memberReader.findByNickname(value)
                    .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
            default -> throw new MemberException(UNSUPPORTED_SEARCH_TYPE);
        };
    }
}