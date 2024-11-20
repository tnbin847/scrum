package com.sukong.scrum.domain.user.enums;

import com.sukong.scrum.global.common.mybatis.CodeEnum;
import lombok.RequiredArgsConstructor;

/**
 * 회원가입 방식에 따라 사용자의 로그인 유형에 대한 코드값을 정의한 Enum
 *
 * @author 박 수 빈
 * @version 1.0.0
 */

@RequiredArgsConstructor
public enum LoginType implements CodeEnum {
    LOCAL ("LOCAL", "로컬"),
    SOCIAL ("OAUTH", "소셜");

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