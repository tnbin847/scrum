package com.sukong.scrum.domain.user.mapper;

import com.sukong.scrum.domain.user.dto.SignUpRequest;
import com.sukong.scrum.domain.user.dto.UserRoleRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 박 수 빈
 * @version 1.0.0
 */

@Mapper
public interface UserMapper {
    boolean existsById(String id);

    boolean existsByEmail(String email);

    int insertUser(SignUpRequest signUpRequest);

    void insertUserRole(UserRoleRequest userRoleRequest);
}