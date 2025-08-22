package com.eat.sleep.auth_identity_service.user.application.usecase.createuseremployee;

import com.eat.sleep.auth_identity_service.user.domain.model.Role;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployeeEntityDomain;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class CreateUserEmployeeDto {
    private String email;
    private boolean active;
    private String password;
    private String cui;

    public UserEmployeeEntityDomain toDomain(UUID employeeId, Role role) {
        return new UserEmployeeEntityDomain(employeeId,email, active, role,password);
    }
}
