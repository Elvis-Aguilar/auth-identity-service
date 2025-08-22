package com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record UserResponseDto(
        String id,
        String email,
        boolean active,
        String roleName,
        String employeeId,
        String customerId
) {


}
