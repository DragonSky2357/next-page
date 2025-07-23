package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
public class CodeId implements Serializable {
    @Column(name = "group_code", length = 40, nullable = false)
    private String groupCode;

    @Column(name = "common_code", length = 40, nullable = false)
    private String commonCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeId)) return false;
        CodeId that = (CodeId) o;
        return Objects.equals(groupCode, that.groupCode) &&
                Objects.equals(commonCode, that.commonCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupCode, commonCode);
    }
}
