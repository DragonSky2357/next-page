package com.dragonsky.nextpage.auth.domain.repository.store;

import com.dragonsky.nextpage.auth.domain.vo.RefreshToken;

public interface AuthStore {
    void saveRefreshToken(long memberId, RefreshToken refreshToken);
    boolean deleteRefreshToken(long memberId);
}
