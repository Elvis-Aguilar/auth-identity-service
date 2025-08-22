package com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;

@Builder(toBuilder = true)
public record TokenDto(
        String token,
        @JsonUnwrapped UserResponseDto user) {
}
