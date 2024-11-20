package com.sukong.scrum.global.common.mybatis;

/**
 * 타입 핸드럴를 적용하고자 하는 Enum 클래스를 일관적으로 구현하기 위한 인터페이스
 *
 * @author 박 수 빈
 * @version 1.0.0
 *
 * @see CodeEnumTypeHandler
 */

public interface CodeEnum {
    /**
     * 데이터베이스 작업의 대상이 되는 문자열의 코드값을 반환한다.
     */
    String getCode();

    /**
     * 뷰에 출력할 코드가 의미하는 이름을 반환한다.
     */
    String getLabel();
}