package com.dragonsky.nextpage.repository;

import com.dragonsky.nextpage.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
