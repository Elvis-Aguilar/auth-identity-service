package com.eat.sleep.auth_identity_service.employee.application.ports.output;

import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;

public interface StoringEmployeeOutputPort {
    Employee save(Employee employee);
}
