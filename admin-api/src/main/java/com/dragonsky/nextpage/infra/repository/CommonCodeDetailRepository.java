package com.dragonsky.nextpage.infra.repository;

import com.dragonsky.nextpage.domain.commoncode.domain.CommonCodeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetail, Long> {
    // 기본 CRUD 지원
}
