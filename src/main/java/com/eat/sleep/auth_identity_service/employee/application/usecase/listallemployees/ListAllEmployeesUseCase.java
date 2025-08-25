package com.eat.sleep.auth_identity_service.employee.application.usecase.listallemployees;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.ListingAllEmployeesNoManagersInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingAllEmployeesNoMangerOutputPort;
import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListAllEmployeesUseCase implements ListingAllEmployeesNoManagersInputPort {

    private final FindingAllEmployeesNoMangerOutputPort findingAllEmployeesNoMangerOutputPort;

    @Override
    public List<EmployeeDomainEntity> listAllAuthors() {
        return this.findingAllEmployeesNoMangerOutputPort.findAllEmployeesNoManger();
    }
}
