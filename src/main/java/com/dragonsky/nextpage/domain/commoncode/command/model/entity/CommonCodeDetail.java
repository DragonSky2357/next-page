package com.dragonsky.nextpage.domain.commoncode.command.model.entity;

import com.dragonsky.nextpage.domain.commoncode.command.model.entity.id.CommonCodeId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_code", length = 30, nullable = false)
    private String groupCode;

    @Column(length = 30, nullable = false)
    private String code;

    @Column(name = "sort_order ", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer sortOrder = 1;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String description;
}
