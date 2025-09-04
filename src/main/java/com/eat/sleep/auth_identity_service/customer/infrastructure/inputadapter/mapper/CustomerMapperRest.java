package com.eat.sleep.auth_identity_service.customer.infrastructure.inputadapter.mapper;

import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;
import com.eat.sleep.auth_identity_service.customer.infrastructure.inputadapter.dto.CustomerResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperRest {

    public CustomerResponseDto toResponseDto(CustomerDomainEntity domainEntity) {

        return CustomerResponseDto.builder()
                .id(domainEntity.getId())
                .phone(domainEntity.getPhone())
                .email(domainEntity.getEmail())
                .cui(domainEntity.getCui())
                .fullName(domainEntity.getFullName())
                .loyaltyPoints(domainEntity.getLoyaltyPoints())
                .address(domainEntity.getAddress())
                .build();

    }
}
