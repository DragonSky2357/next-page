package com.dragonsky.nextpage.domain.member.cache;

import java.io.Serializable;

public record MemberCache(
        Long id,
        String email
) implements Serializable {
}
