package com.dragonsky.nextpage.domain.commoncode.domain.id;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class CommonCodeId implements Serializable {
    private String groupCode;
    private String code;
}