package com.eat.sleep.auth_identity_service.employee.application.ports.output;

import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;

import java.util.Optional;

public interface FindingEmployeeByCuiOutputPort {
    Optional<EmployeeDomainEntity> findByEmployeeByCui(String cui);
}
