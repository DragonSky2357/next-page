package com.dragonsky.nextpage.domain.auth.repository.reader;

import com.dragonsky.nextpage.domain.auth.vo.RefreshToken;

public interface AuthReader {
    RefreshToken findRefreshToken(long memberId);
}
