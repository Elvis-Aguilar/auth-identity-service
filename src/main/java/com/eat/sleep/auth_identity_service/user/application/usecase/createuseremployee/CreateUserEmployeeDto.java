package com.eat.sleep.auth_identity_service.user.application.usecase.createuseremployee;

import com.eat.sleep.auth_identity_service.user.domain.model.Role;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class CreateUserEmployeeDto {
    private String email;
    private boolean active;
    private String role;
    private String password;

    public UserEmployee toDomain(UUID employeeId){
        return new UserEmployee(employeeId,email, active, new Role(role),password);
    }
}
