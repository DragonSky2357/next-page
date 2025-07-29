package com.dragonsky.nextpage.domain.commoncode.vo;

import lombok.Value;

@Value
public class CategoryCode {
    int value;

    public CategoryCode(int value) {
        this.value = value;
    }
}