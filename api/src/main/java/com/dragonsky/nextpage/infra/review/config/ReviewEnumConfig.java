package com.dragonsky.nextpage.infra.review.config;

import com.dragonsky.nextpage.domain.review.model.category.Category;
import com.dragonsky.nextpage.domain.review.model.status.Status;
import com.dragonsky.nextpage.domain.review.model.tag.Tag;
import com.dragonsky.nextpage.mapper.EnumMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewEnumConfig {
    @Bean
    public EnumMapper reviewEnumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("status", Status.class);
        enumMapper.put("category", Category.class);
        enumMapper.put("tag", Tag.class);
        return enumMapper;
    }
}
