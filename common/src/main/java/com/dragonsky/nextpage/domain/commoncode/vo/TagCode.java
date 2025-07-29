package com.dragonsky.nextpage.domain.commoncode.vo;

import lombok.Value;

@Value
public class TagCode {
    int value;

    public TagCode(int value) {
        this.value = value;
    }
}