package com.eat.sleep.auth_identity_service.employee.application.usecase.listallemployees;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.ListingAllEmployeesInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.ListingAllEmployeesNoManagersInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingAllEmployeesNoMangerOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingAllEmployeesOutputPort;
import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListAllEmployeesUseCase implements ListingAllEmployeesNoManagersInputPort, ListingAllEmployeesInputPort {

    private final FindingAllEmployeesNoMangerOutputPort findingAllEmployeesNoMangerOutputPort;
    private final FindingAllEmployeesOutputPort findingAllEmployeesOutputPort;

    @Override
    public List<EmployeeDomainEntity> listAllEmployeesNoManagers() {
        return this.findingAllEmployeesNoMangerOutputPort.findAllEmployeesNoManger();
    }

    @Override
    public List<EmployeeDomainEntity> findAllEmployees() {
        return findingAllEmployeesOutputPort.findAllEmployees();
    }
}
