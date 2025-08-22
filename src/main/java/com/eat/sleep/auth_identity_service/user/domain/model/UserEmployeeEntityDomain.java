package com.eat.sleep.auth_identity_service.user.domain.model;

import com.eat.sleep.auth_identity_service.common.application.exception.EntityConflictUserType;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class UserEmployeeEntityDomain extends UserEntityDomain {

    private UUID employeeId;

    public UserEmployeeEntityDomain(UUID id, UUID employeeId, String email, boolean active, Role role, String password) {
        super(id,email,password, active, role);
        this.employeeId = employeeId;
        validate();
    }

    public UserEmployeeEntityDomain(UUID employeeId, String email, boolean active, Role role, String password) {
        super(email,password, active, role);
        this.employeeId = employeeId;
        validate();
    }

    private void validate() {

        if (employeeId == null) {
            throw new EntityConflictUserType("El usuario debe ser un empleado");
        }

        if (Objects.equals(this.role, "CUSTOMER")){
            throw new EntityConflictUserType("El usuario no pude ser cliente");
        }
    }


}
