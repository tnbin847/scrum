package com.sukong.scrum.global.common.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * {@link CodeEnum} 인터페이스를 구현한 {@link Enum}을 마이바티스를 이용하여 데이터베이스 처리하기 위한 매핑 처리를 수행하는 타입 핸들러
 * <p>
 * MyBatis에서 기본적으로 제공하는 {@link Enum}을 처리하기 위해 {@link org.apache.ibatis.type.EnumTypeHandler}와
 * {@link org.apache.ibatis.type.EnumOrdinalTypeHandler}가 존재하지만, 각각 상수의 이름을 매핑하며, 후자의 경우 상수의 위치값을 매핑하기
 * 때문에 코드단에서 가독성을 위해 정의한 상수의 이름이 아닌 해당 상수가 저장하고 있는 코드값을 처리하기 위해 별도의 타입 핸들러를 구현함.
 * </p>
 *
 * @param <E>  타입 핸들러에서 처리할 {@link Enum}
 * @author 박 수 빈
 * @version 1.0.0
 */

@MappedTypes(CodeEnum.class)
public class CodeEnumTypeHandler<E extends Enum<E> & CodeEnum> extends BaseTypeHandler<E> {
    private final Class<E> type;    // 타입 핸들러에서 처리할 Enum
    private final E[] constants;    // Enum 내부에 정의된 상수들로 이루어진 배열

    public CodeEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null.");
        }//end if
        this.type = type;
        this.constants = type.getEnumConstants();
        if (!type.isInterface() && this.constants == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }//end if
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.wasNull() ? null : getCodeEnum(rs.getString(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.wasNull() ? null : getCodeEnum(rs.getString(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.wasNull() ? null : getCodeEnum(cs.getString(columnIndex));
    }

    /**
     * 타입 핸들러에서 처리할 {@link Enum} 내의 상수값들 중 인자로 전달받은 코드값과 일치하는 상수값이 존재할 경우 해당 {@link Enum}을 반환한다.
     *
     * @param code  데이터베이스로부터 가져온 코드값
     * @return      E
     */
    private E getCodeEnum(String code) {
        return Arrays.stream(constants)
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot convert '" + code + "' to '" + type.getSimpleName() + "'."));
    }
}