package com.eat.sleep.auth_identity_service.employee.application.ports.output;

import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;

import java.util.Optional;

public interface FindingEmployeeByEmailOutputPort {
    Optional<Employee> findByEmployeeByEmail(String email);
}
