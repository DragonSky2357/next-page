package com.dragonsky.nextpage.domain.review.model.category;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CategoryGroup {
    LITERATURE("문학", Arrays.asList(Category.KOREAN_LITERATURE, Category.FOREIGN_LITERATURE, Category.POETRY, Category.CLASSIC)),
    HUMANITIES("인문학", Arrays.asList(Category.PHILOSOPHY, Category.HISTORY, Category.RELIGION, Category.ART_CULTURE,Category.LANGUAGE)),
    SOCIAL_SCIENCE("사회과학", Arrays.asList(Category.PSYCHOLOGY, Category.SOCIOLOGY, Category.POLITICS, Category.ECONOMICS,Category.EDUCATION)),
    NATURAL_SCIENCE("자연과학", Arrays.asList(Category.MATHEMATICS, Category.PHYSICS, Category.CHEMISTRY, Category.BIOLOGY,Category.MEDICINE)),
    TECHNOLOGY("기술/공학", Arrays.asList(Category.COMPUTER_SCIENCE, Category.ENGINEERING, Category.IT_PROGRAMMING, Category.DATA_SCIENCE)),
    PRACTICAL("실용/취미", Arrays.asList(Category.BUSINESS, Category.SELF_DEVELOPMENT, Category.CAREER, Category.INVESTMENT,Category.HEALTH_FITNESS, Category.COOKING, Category.TRAVEL, Category.HOBBY)),
    GENRE_FICTION("장르소설", Arrays.asList(Category.ROMANCE, Category.MYSTERY_THRILLER, Category.FANTASY, Category.SCIENCE_FICTION, Category.HORROR, Category.HISTORICAL_FICTION)),
    AGE_GROUP("연령별", Arrays.asList(Category.CHILDREN, Category.YOUNG_ADULT)),
    OTHER("기타", Arrays.asList(Category.COMIC_WEBTOON, Category.REFERENCE)),
    EMPTY("없음",Collections.EMPTY_LIST);

    private String title;
    private List<Category> categoryList;


    CategoryGroup(String title, List<Category> categoryList) {
        this.title = title;
        this.categoryList = categoryList;
    }

    public static CategoryGroup frindByCategory(Category category) {
        return Arrays.stream(CategoryGroup.values())
                .filter((cg -> cg.hasCategoryCode(category)))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasCategoryCode(Category category) {
        return categoryList.stream()
                .anyMatch(c -> c == category);
    }

    public String getTitle() {
        return title;
    }
}
