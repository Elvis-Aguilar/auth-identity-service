package com.eat.sleep.auth_identity_service.customer.application.ports.output;

import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;

import java.util.List;

public interface FindingAllCustomersOutputPort {

    List<CustomerDomainEntity> findAllCustomers();
}
