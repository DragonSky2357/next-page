package com.dragonsky.nextpage.domain.auth.repository.store;

import com.dragonsky.nextpage.domain.auth.vo.RefreshToken;

public interface AuthStore {
    void saveRefreshToken(long memberId, RefreshToken refreshToken);
    boolean deleteRefreshToken(long memberId);
}
