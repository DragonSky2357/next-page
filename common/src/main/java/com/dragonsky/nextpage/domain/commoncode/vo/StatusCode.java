package com.dragonsky.nextpage.domain.commoncode.vo;

import lombok.Value;

@Value
public class StatusCode {
    int value;

    public StatusCode(int value) {
        this.value = value;
    }
}
