package com.dragonsky.nextpage.service.commoncode.impl;

import com.dragonsky.nextpage.dto.CommonCode.AddCommonCodeRequest;
import com.dragonsky.nextpage.infra.repository.CommonCodeRepository;
import com.dragonsky.nextpage.service.commoncode.CommonCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;

    @Override
    public void AddCommonCode(AddCommonCodeRequest request) {

    }
}
