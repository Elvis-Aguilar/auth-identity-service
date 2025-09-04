package com.eat.sleep.auth_identity_service.customer.application.ports.input;

import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;

import java.util.List;


public interface ListAllCustomersInputPort {
    List<CustomerDomainEntity> ListAllCustomers();
}
