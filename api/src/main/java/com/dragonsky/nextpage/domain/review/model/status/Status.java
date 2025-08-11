package com.dragonsky.nextpage.domain.review.model.status;

import com.dragonsky.nextpage.mapper.EnumMapperType;

public enum Status implements EnumMapperType {
    WANT("읽고 싶은"),
    READING("읽는 중"),
    COMPLETED("완독"),
    PAUSED("일시정지"),
    DROPPED("포기");

    private String title;

    Status(String title) { this.title = title; }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
