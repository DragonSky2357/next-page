package com.dragonsky.nextpage.review.domain.model.category;

import com.dragonsky.nextpage.mapper.EnumMapperType;

public enum Category implements EnumMapperType {
    // 문학
    KOREAN_LITERATURE("한국문학"),
    FOREIGN_LITERATURE("외국문학"),
    POETRY("시/에세이"),
    CLASSIC("고전문학"),

    // 인문학
    PHILOSOPHY("철학"),
    HISTORY("역사"),
    RELIGION("종교/신학"),
    ART_CULTURE("예술/문화"),
    LANGUAGE("언어학"),

    // 사회과학
    PSYCHOLOGY("심리학"),
    SOCIOLOGY("사회학"),
    POLITICS("정치학"),
    ECONOMICS("경제학"),
    EDUCATION("교육학"),

    // 자연과학
    MATHEMATICS("수학"),
    PHYSICS("물리학"),
    CHEMISTRY("화학"),
    BIOLOGY("생물학"),
    MEDICINE("의학"),

    // 기술/공학
    COMPUTER_SCIENCE("컴퓨터과학"),
    ENGINEERING("공학"),
    IT_PROGRAMMING("IT/프로그래밍"),
    DATA_SCIENCE("데이터사이언스"),

    // 실용/취미
    BUSINESS("경영/비즈니스"),
    SELF_DEVELOPMENT("자기계발"),
    CAREER("취업/진로"),
    INVESTMENT("투자/재테크"),
    HEALTH_FITNESS("건강/운동"),
    COOKING("요리"),
    TRAVEL("여행"),
    HOBBY("취미/레저"),

    // 장르소설
    ROMANCE("로맨스"),
    MYSTERY_THRILLER("추리/스릴러"),
    FANTASY("판타지"),
    SCIENCE_FICTION("SF"),
    HORROR("공포/호러"),
    HISTORICAL_FICTION("사극/역사소설"),

    // 연령별
    CHILDREN("어린이"),
    YOUNG_ADULT("청소년"),

    // 기타
    COMIC_WEBTOON("만화/웹툰"),
    REFERENCE("참고서/사전");

    private String title;

    Category(String title) { this.title = title; }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
