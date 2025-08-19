package com.eat.sleep.auth_identity_service.employee.application.ports.input;

import com.eat.sleep.auth_identity_service.employee.application.usecase.dto.CreateEmployeeDto;
import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import jakarta.validation.Valid;

public interface CreatingEmployeeInputPort {
    Employee createEmployee(@Valid CreateEmployeeDto createEmployeeDto);
}
