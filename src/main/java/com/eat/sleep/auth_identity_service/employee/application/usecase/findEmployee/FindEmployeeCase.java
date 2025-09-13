package com.eat.sleep.auth_identity_service.employee.application.usecase.findEmployee;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.FindEmployeeByIdInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeIdOutputPort;
import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindEmployeeCase implements FindEmployeeByIdInputPort {

    private final FindingEmployeeIdOutputPort outputPort;


    @Override
    public EmployeeDomainEntity finEmployeeById(UUID id) {
        return outputPort.findByEmployeeById(id);
    }
}
