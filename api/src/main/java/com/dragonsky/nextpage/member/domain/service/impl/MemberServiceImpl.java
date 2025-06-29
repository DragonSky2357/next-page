package com.dragonsky.nextpage.member.domain.service.impl;

import com.dragonsky.nextpage.member.application.converter.MemberConverter;
import com.dragonsky.nextpage.member.presentation.dto.request.MemberRegistrationRequest;
import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.member.domain.exception.MemberErrorCode;
import com.dragonsky.nextpage.member.domain.exception.MemberException;
import com.dragonsky.nextpage.member.domain.repository.command.MemberCommandRepository;
import com.dragonsky.nextpage.member.domain.repository.query.MemberQueryRepository;
import com.dragonsky.nextpage.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberConverter memberConverter;
    private final MemberCommandRepository memberCommandRepository;
    private final MemberQueryRepository memberQueryRepository;

    @Override
    public Member register(MemberRegistrationRequest request) {
        validateDuplicateEmail(request.email());
        validateDuplicateNickname(request.nickname());

        Member member =  memberConverter.toEntity(request);
        return memberCommandRepository.save(member);
    }

    private void validateDuplicateEmail(String email) {
        if (memberQueryRepository.existsByEmail(email)) {
            throw new MemberException(MemberErrorCode.EMAIL_ALREADY_EXISTS);
        }
    }

    private void validateDuplicateNickname(String nickname) {
        if (memberQueryRepository.existsByNickname(nickname)) {
            throw new MemberException(MemberErrorCode.NICKNAME_ALREADY_EXISTS);
        }
    }
}