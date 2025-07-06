package com.dragonsky.nextpage.presentation.member.controller;

import com.dragonsky.nextpage.application.member.MemberApplication;
import com.dragonsky.nextpage.presentation.member.converter.MemberApplicationConverter;
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
    private final MemberApplicationConverter memberConverter;
    private final MemberApplication memberApplication;

    @PostMapping
    public ResponseEntity<MemberRegistrationApiResponse> registerMember(@Valid @RequestBody MemberRegistrationRequest request) {
        var response = memberApplication.register(request);
        var apiResponse = memberConverter.toApiResponse(response);
        return ResponseEntity.ok(apiResponse);
    }
}
