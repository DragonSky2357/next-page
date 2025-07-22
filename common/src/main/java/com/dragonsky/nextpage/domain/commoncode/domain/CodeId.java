package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class CodeId implements Serializable {
    @Column(name = "common_code", length = 40, nullable = false)
    private String commonCode;

    @Column(name = "code_key", length = 40, nullable = false)
    private String codeKey;
}
