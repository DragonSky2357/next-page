package com.dragonsky.nextpage.domain.member.service.impl;

import com.dragonsky.nextpage.application.member.converter.MemberPresentationConverter;
import com.dragonsky.nextpage.application.member.dto.request.MemberRegistrationDto;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.exception.MemberErrorCode;
import com.dragonsky.nextpage.domain.member.exception.MemberException;
import com.dragonsky.nextpage.domain.member.repository.command.MemberStore;
import com.dragonsky.nextpage.domain.member.repository.query.MemberReader;
import com.dragonsky.nextpage.domain.member.service.MemberService;
import com.dragonsky.nextpage.util.security.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberPresentationConverter memberConverter;
    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final PasswordEncoderUtil passwordEncoderUtil;

    @Override
    @Transactional
    public Long register(MemberRegistrationDto dto) {
        validateDuplicate(dto);

        Member member = createMember(dto);
        return memberStore.save(member).getId();
    }

    private void validateDuplicate(MemberRegistrationDto dto) {
        validateDuplicateEmail(dto.email());
        validateDuplicateNickname(dto.nickname());
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

    private Member createMember(MemberRegistrationDto dto) {
        String encodedPassword = passwordEncoderUtil.encode(dto.password());

        Member member = memberConverter.toEntity(dto);
        member.setPassword(encodedPassword);

        return member;
    }
}