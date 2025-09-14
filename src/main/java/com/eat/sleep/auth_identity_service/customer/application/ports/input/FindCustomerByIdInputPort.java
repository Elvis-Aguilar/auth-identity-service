package com.eat.sleep.auth_identity_service.customer.application.ports.input;

import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;

import java.util.UUID;

public interface FindCustomerByIdInputPort {
    CustomerDomainEntity getCustomerById(UUID id);
}
