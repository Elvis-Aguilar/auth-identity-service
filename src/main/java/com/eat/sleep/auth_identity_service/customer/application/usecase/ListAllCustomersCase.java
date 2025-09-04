package com.eat.sleep.auth_identity_service.customer.application.usecase;


import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.customer.application.ports.input.ListAllCustomersInputPort;
import com.eat.sleep.auth_identity_service.customer.application.ports.output.FindingAllCustomersOutputPort;
import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListAllCustomersCase implements ListAllCustomersInputPort {

    private final FindingAllCustomersOutputPort findingAllCustomersOutputPort;

    @Override
    public List<CustomerDomainEntity> ListAllCustomers() {
        return findingAllCustomersOutputPort.findAllCustomers();
    }
}
