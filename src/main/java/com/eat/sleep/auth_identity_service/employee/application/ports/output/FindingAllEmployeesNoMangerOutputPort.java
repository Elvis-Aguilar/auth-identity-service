package com.eat.sleep.auth_identity_service.employee.application.ports.output;

import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;

import java.util.List;

public interface FindingAllEmployeesNoMangerOutputPort {

    List<EmployeeDomainEntity> findAllEmployeesNoManger();
}
