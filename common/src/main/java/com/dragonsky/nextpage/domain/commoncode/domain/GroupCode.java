package com.dragonsky.nextpage.domain.commoncode.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "group_code")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupCode extends BaseEntity {

    @Id
    @Column(name = "code", length = 40, nullable = false)
    private String code;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @Column(name = "attr_value1", length = 100)
    private String attrValue1;

    @Column(name = "attr_value2", length = 100)
    private String attrValue2;

    @Column(name = "attr_value3", length = 100)
    private String attrValue3;

    @Column(name = "attr_value4", length = 100)
    private String attrValue4;

    @Column(name = "attr_value5", length = 100)
    private String attrValue5;
}
