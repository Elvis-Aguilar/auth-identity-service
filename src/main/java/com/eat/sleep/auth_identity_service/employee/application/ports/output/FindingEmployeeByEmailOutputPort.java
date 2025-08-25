package com.eat.sleep.auth_identity_service.employee.application.ports.output;

import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;

import java.util.Optional;

public interface FindingEmployeeByEmailOutputPort {
    Optional<EmployeeDomainEntity> findByEmployeeByEmail(String email);
}
