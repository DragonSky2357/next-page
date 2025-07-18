package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class CodeId implements Serializable {
    private String groupCode;
    private String subCode;
}
