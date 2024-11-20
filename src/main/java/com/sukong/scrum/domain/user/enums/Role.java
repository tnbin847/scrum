package com.sukong.scrum.domain.user.enums;

import com.sukong.scrum.global.common.mybatis.CodeEnum;
import lombok.RequiredArgsConstructor;

/**
 * 사용자에게 부여될 권한에 대한 코드값을 정의한 Enum
 *
 * @author 박 수 빈
 * @version 1.0.0
 */

@RequiredArgsConstructor
public enum Role implements CodeEnum {
    USER ("ROLE_USER", "일반회원"),
    ADMIN ("ROLE_ADMIN", "관리자");

    private final String code;
    private final String label;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}