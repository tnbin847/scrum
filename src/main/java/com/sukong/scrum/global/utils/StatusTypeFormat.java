package com.sukong.scrum.global.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * 상태 값 처리를 위해 각기 다른 타입의 데이터를 상응되는 의미별로 묶어 정의한 Enum
 * 
 * @author      박 수 빈
 * @version     1.0.0
 */

@RequiredArgsConstructor
@Getter
public enum StatusTypeFormat {
    YES (1, "Y", true),
    NO (0, "N", false);

    private final int number;
    private final String symbol;
    private final boolean bool;

    /**
     * 인자로 전달된 정수형의 값을 알맞은 논리형 상태 값으로 반환한다.
     *
     * @param value     논리형 상태값으로 변환하고자 하는 정수형 인자 값
     * @return          {@code true} 또는 {@code false}
     */
    public Boolean toBoolean(int value) {
        return Arrays.stream(values())
                .filter(statusTypeFormat -> statusTypeFormat.getNumber() == value)
                .findFirst()
                .map(StatusTypeFormat::isBool)
                .orElseThrow(() -> new IllegalArgumentException("Cannot convert '" + value + "' to boolean type."));
    }
}