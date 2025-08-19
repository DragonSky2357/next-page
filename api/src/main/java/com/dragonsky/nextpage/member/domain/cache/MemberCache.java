package com.dragonsky.nextpage.member.domain.cache;

import java.io.Serializable;

public record MemberCache(
        Long id,
        String email
) implements Serializable {
}
