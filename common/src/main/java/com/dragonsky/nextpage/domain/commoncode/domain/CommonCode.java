package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "common_code",
        uniqueConstraints = @UniqueConstraint(columnNames = {"group_code", "common_code"}))
@SQLDelete(sql = "UPDATE common_code SET is_active = false, is_deleted = true WHERE group_code = ? AND common_code = ?")
@Where(clause = "is_active = true AND is_deleted = false")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonCode extends BaseEntity {

    @EmbeddedId
    private CodeId id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(name = "sort_order", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer sortOrder = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "parent_group_code", referencedColumnName = "group_code", insertable = false, updatable = false),
            @JoinColumn(name = "parent_common_code", referencedColumnName = "common_code", insertable = false, updatable = false)
    })
    private CommonCode parentCode;
}
