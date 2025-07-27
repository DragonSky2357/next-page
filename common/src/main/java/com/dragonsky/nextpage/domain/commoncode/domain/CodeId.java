package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CodeId implements Serializable {

    @Column(name = "group_code", length = 40, nullable = false)
    private String groupCode;

    @Column(name = "common_code", length = 40, nullable = false)
    private String commonCode;
}
