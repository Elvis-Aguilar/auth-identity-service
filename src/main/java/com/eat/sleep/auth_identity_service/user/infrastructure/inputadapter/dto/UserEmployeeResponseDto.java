package com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto;

import com.eat.sleep.auth_identity_service.user.domain.model.Role;
import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record UserEmployeeResponseDto(
         UUID id,
         UUID employeeId,
         String email,
         boolean active,
         Role role
) {
}
