package com.dragonsky.nextpage.review.infra.config;

import com.dragonsky.nextpage.review.domain.model.category.Category;
import com.dragonsky.nextpage.review.domain.model.status.Status;
import com.dragonsky.nextpage.review.domain.model.tag.Tag;
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
