package com.eat.sleep.auth_identity_service.customer.infrastructure.inputadapter.dto;


import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record CustomerResponseDto(
        UUID id,
        String email,
        String fullName,
        String cui,
        String phone,
        String address,
        int loyaltyPoints
) {
}
