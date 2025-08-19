package com.dragonsky.nextpage.auth.domain.repository.reader;

import com.dragonsky.nextpage.auth.domain.vo.RefreshToken;

public interface AuthReader {
    RefreshToken findRefreshToken(long memberId);
}
