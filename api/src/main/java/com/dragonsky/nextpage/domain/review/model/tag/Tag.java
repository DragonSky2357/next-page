package com.dragonsky.nextpage.domain.review.model.tag;

import com.dragonsky.nextpage.mapper.EnumMapperType;

public enum Tag implements EnumMapperType {
    // 읽기 난이도
    BEGINNER_FRIENDLY("입문서", "초보자도 쉽게 읽을 수 있는"),
    INTERMEDIATE("중급", "어느 정도 배경지식이 필요한"),
    ADVANCED("고급", "전문적이고 깊이 있는"),
    ACADEMIC("학술적", "학문적 깊이가 있는"),

    // 분량/길이
    QUICK_READ("빠른 읽기", "1-2시간 내 완독 가능"),
    SHORT("짧은", "200페이지 미만"),
    MEDIUM("보통", "200-400페이지"),
    LONG("긴", "400페이지 이상"),
    SERIES("시리즈", "연속된 여러 권"),

    // 분위기/톤
    INSPIRATIONAL("영감을 주는", "동기부여와 영감"),
    EMOTIONAL("감동적인", "감정을 자극하는"),
    HUMOROUS("유머러스한", "재미있고 웃긴"),
    SERIOUS("진지한", "무겁고 심각한 주제"),
    DARK("어두운", "우울하거나 비관적인"),
    UPLIFTING("밝은", "긍정적이고 희망적인"),
    THOUGHT_PROVOKING("생각하게 하는", "깊은 사색을 유도"),

    // 주제/테마
    LOVE_RELATIONSHIP("사랑/관계", "연애와 인간관계"),
    FAMILY("가족", "가족과의 관계"),
    FRIENDSHIP("우정", "친구 관계"),
    COMING_OF_AGE("성장", "성장과 성숙"),
    SOCIAL_ISSUES("사회문제", "사회적 이슈"),
    IDENTITY("정체성", "자아 찾기"),
    DEATH_LOSS("죽음/상실", "죽음과 슬픔"),
    WAR_CONFLICT("전쟁/갈등", "전쟁과 분쟁"),
    NATURE_ENVIRONMENT("자연/환경", "환경과 생태"),

    // 배경/설정
    CONTEMPORARY("현대", "현재 시대 배경"),
    HISTORICAL("역사적", "과거 시대 배경"),
    FUTURE("미래", "미래 사회"),
    KOREA("한국", "한국적 배경"),
    WESTERN("서구", "서양 문화권"),
    ASIAN("아시아", "아시아 문화권"),
    URBAN("도시", "도시 배경"),
    RURAL("시골", "시골/자연 배경"),

    // 특별한 특징
    AWARD_WINNER("수상작", "문학상 수상작"),
    BESTSELLER("베스트셀러", "인기 도서"),
    DEBUT_WORK("데뷔작", "작가의 첫 작품"),
    TRANSLATED("번역서", "외국어에서 번역"),
    ADAPTED("영상화", "영화/드라마로 제작"),
    CONTROVERSIAL("논란작", "사회적 논란"),
    CULT_CLASSIC("컬트", "특정 집단에서 사랑받는"),

    // 읽기 목적/상황
    STUDY("공부용", "학습과 연구용"),
    ENTERTAINMENT("오락용", "재미와 즐거움"),
    SELF_IMPROVEMENT("자기계발용", "개인 성장용"),
    PROFESSIONAL("업무용", "직업적 필요"),
    BEDTIME("잠자리용", "잠들기 전 읽기"),
    COMMUTE("출퇴근용", "이동 중 읽기"),
    DISCUSSION("토론용", "독서모임 적합"),

    // 스타일/형식
    NARRATIVE("서사적", "이야기 중심"),
    ESSAY_("에세이형", "수필 형태"),
    INTERVIEW("인터뷰", "대화 형식"),
    ILLUSTRATED("일러스트", "그림이 풍부한"),
    PHOTOGRAPHY("사진", "사진이 많은"),
    INFOGRAPHIC("인포그래픽", "시각적 정보"),
    PRACTICAL_GUIDE("실용 가이드", "실용적 안내서"),

    // 대상 독자
    FOR_BEGINNERS("초심자용", "처음 접하는 사람"),
    FOR_EXPERTS("전문가용", "전문 지식 보유자"),
    FOR_STUDENTS("학생용", "학생 대상"),
    FOR_PROFESSIONALS("직장인용", "직장인 대상"),
    FOR_PARENTS("부모용", "부모 대상"),
    FOR_TEENS("십대용", "청소년 대상"),
    FOR_WOMEN("여성용", "여성 독자 대상"),
    FOR_MEN("남성용", "남성 독자 대상");

    private final String title;
    private final String description;

    Tag(String title, String description){
        this.title = title;
        this.description = description;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
