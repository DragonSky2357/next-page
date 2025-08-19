package com.dragonsky.nextpage.review.domain.model.tag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TagGroup {
    MOOD_TONE("분위기/톤", Arrays.asList(Tag.INSPIRATIONAL, Tag.EMOTIONAL, Tag.HUMOROUS, Tag.SERIOUS, Tag.DARK, Tag.UPLIFTING, Tag.THOUGHT_PROVOKING)),
    THEME_SUBJECT("주제/테마", Arrays.asList(Tag.LOVE_RELATIONSHIP, Tag.FAMILY, Tag.FRIENDSHIP, Tag.COMING_OF_AGE, Tag.SOCIAL_ISSUES, Tag.IDENTITY, Tag.DEATH_LOSS, Tag.WAR_CONFLICT, Tag.NATURE_ENVIRONMENT)),
    SETTING_BACKGROUND("배경/설정", Arrays.asList(Tag.CONTEMPORARY, Tag.HISTORICAL, Tag.FUTURE, Tag.KOREA, Tag.WESTERN, Tag.ASIAN, Tag.URBAN, Tag.RURAL)),
    SPECIAL_FEATURES("특별한 특징", Arrays.asList(Tag.AWARD_WINNER, Tag.BESTSELLER, Tag.DEBUT_WORK, Tag.TRANSLATED, Tag.ADAPTED, Tag.CONTROVERSIAL, Tag.CULT_CLASSIC)),
    PURPOSE_SITUATION("읽기 목적/상황", Arrays.asList(Tag.STUDY, Tag.ENTERTAINMENT, Tag.SELF_IMPROVEMENT, Tag.PROFESSIONAL, Tag.BEDTIME, Tag.COMMUTE, Tag.DISCUSSION)),
    STYLE_FORMAT("스타일/형식", Arrays.asList(Tag.NARRATIVE, Tag.ESSAY_, Tag.INTERVIEW, Tag.ILLUSTRATED, Tag.PHOTOGRAPHY, Tag.INFOGRAPHIC, Tag.PRACTICAL_GUIDE)),
    TARGET_READER("대상 독자", Arrays.asList(Tag.FOR_BEGINNERS, Tag.FOR_EXPERTS, Tag.FOR_STUDENTS, Tag.FOR_PROFESSIONALS, Tag.FOR_PARENTS, Tag.FOR_TEENS, Tag.FOR_WOMEN, Tag.FOR_MEN)),
    EMPTY("없음", Collections.emptyList());

    private String title;
    private List<Tag> tagList;

    TagGroup(String title, List<Tag> tagList){
        this.title = title;
        this.tagList = tagList;
    }


}
