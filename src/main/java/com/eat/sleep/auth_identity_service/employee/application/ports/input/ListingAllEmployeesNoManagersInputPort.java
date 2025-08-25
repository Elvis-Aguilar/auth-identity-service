package com.eat.sleep.auth_identity_service.employee.application.ports.input;

import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;

import java.util.List;

public interface ListingAllEmployeesNoManagersInputPort {

    List<EmployeeDomainEntity> listAllAuthors();
}
