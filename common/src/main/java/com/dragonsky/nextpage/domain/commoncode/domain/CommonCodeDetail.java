package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(
        name = "common_code_detail",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"group_code", "code"}),
                @UniqueConstraint(columnNames = {"group_code", "sort_order"})
        }
)
@SQLDelete(sql = "UPDATE common_code_detail SET is_active = false WHERE id = ?")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonCodeDetail extends BaseEntity {

    @EmbeddedId
    private CodeId id;

    @Column(nullable = false)
    private Integer codeValue;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(name = "sort_order ", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer sortOrder = 1;
}
