package com.sukong.scrum.domain.user.dto;

import com.sukong.scrum.domain.user.enums.Role;
import com.sukong.scrum.global.utils.StatusTypeFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 박 수 빈
 * @version 1.0.0
 */

@NoArgsConstructor
@Getter
public class UserRoleRequest {
    private Long userId;

    private Role role;

    private String useYn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public UserRoleRequest(Long userId, Role role, StatusTypeFormat statusTypeFormat,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.role = role;
        this.useYn = statusTypeFormat.getSymbol();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}