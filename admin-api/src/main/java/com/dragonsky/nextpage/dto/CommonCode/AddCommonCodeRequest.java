package com.dragonsky.nextpage.dto.CommonCode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddCommonCodeRequest(
    @NotBlank(message = "코드는 필수입니다.")
    @Size(max = 30, message = "코드는 최대 30자까지 가능합니다.")
    String code,

    @NotBlank(message = "이름은 필수입니다.")
    @Size(max = 50, message = "이름은 최대 50자까지 가능합니다.")
    String name,

    @Size(max = 255, message = "설명은 최대 255자까지 가능합니다.")
    String description
) {}

