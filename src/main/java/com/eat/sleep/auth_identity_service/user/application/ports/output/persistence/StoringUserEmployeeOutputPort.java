package com.eat.sleep.auth_identity_service.user.application.ports.output.persistence;

import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployeeEntityDomain;

public interface StoringUserEmployeeOutputPort {
    UserEmployeeEntityDomain save(UserEmployeeEntityDomain userEmployee, Employee employee);
}
