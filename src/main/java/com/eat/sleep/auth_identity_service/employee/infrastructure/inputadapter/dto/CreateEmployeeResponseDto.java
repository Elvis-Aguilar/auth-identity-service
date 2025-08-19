package com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(toBuilder = true)
public record CreateEmployeeResponseDto(
        UUID id,
        String email,
        String fullName,
        String cui,
        String phone,
        String jobPosition,
        BigDecimal salary,
        String address,
        UUID hotelId,
        UUID restaurantId
) {
}
