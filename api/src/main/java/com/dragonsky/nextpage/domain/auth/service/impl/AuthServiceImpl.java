package com.dragonsky.nextpage.domain.auth.service.impl;

import com.dragonsky.nextpage.application.auth.dto.input.LoginInput;
import com.dragonsky.nextpage.application.auth.dto.input.LoginMemberInput;
import com.dragonsky.nextpage.domain.auth.converter.AuthConverter;
import com.dragonsky.nextpage.domain.auth.repository.reader.AuthReader;
import com.dragonsky.nextpage.domain.auth.repository.store.AuthStore;
import com.dragonsky.nextpage.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final AuthConverter authConverter;
    private final AuthStore authStore;
    private final AuthReader authReader;

    @Override
    public void login(LoginMemberInput input) {

    }
}
