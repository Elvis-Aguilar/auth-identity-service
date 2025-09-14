package com.eat.sleep.auth_identity_service.customer.application.usecase;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.customer.application.ports.input.FindCustomerByIdInputPort;
import com.eat.sleep.auth_identity_service.customer.application.ports.output.FindCustomerByIdOutputPort;
import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindCustomerByIdCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort outputPort;

    @Override
    public CustomerDomainEntity getCustomerById(UUID id) {
        return outputPort.findCustomerById(id);
    }
}
