package com.dragonsky.nextpage.presentation.member.controller;

import com.dragonsky.nextpage.application.member.MemberApplication;
import com.dragonsky.nextpage.presentation.member.converter.MemberPresentationConverter;
import com.dragonsky.nextpage.presentation.member.dto.request.MemberRegistrationRequest;
import com.dragonsky.nextpage.presentation.member.dto.response.MemberRegistrationApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberPresentationConverter memberConverter;
    private final MemberApplication memberApplication;

    @PostMapping("/signup")
    public ResponseEntity<MemberRegistrationApiResponse> registerMember(@Valid @RequestBody MemberRegistrationRequest request) {
        var registrationInput = memberConverter.fromRequest(request);
        var response = memberApplication.register(registrationInput);
        var apiResponse = memberConverter.toApiResponse(response);
        return ResponseEntity.ok(apiResponse);
    }
}
