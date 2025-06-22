package com.dragonsky.nextpage.infra.repository;

import com.dragonsky.nextpage.domain.commoncode.domain.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {
}