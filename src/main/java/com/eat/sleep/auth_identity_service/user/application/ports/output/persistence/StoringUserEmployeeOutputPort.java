package com.eat.sleep.auth_identity_service.user.application.ports.output.persistence;

import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployeeEntityDomain;

public interface StoringUserEmployeeOutputPort {
    UserEmployeeEntityDomain save(UserEmployeeEntityDomain userEmployee, EmployeeDomainEntity employee);
}
