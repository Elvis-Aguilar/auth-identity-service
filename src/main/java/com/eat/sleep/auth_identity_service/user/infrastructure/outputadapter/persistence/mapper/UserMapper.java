package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.mapper;

import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.entity.RoleDBEntity;
import com.eat.sleep.auth_identity_service.user.domain.model.Role;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.entity.UserDBEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEmployee toDomain(UserDBEntity userDBEntity){
        if (userDBEntity == null) return null;

        return new UserEmployee(userDBEntity.getId(),
                userDBEntity.getEmployee().getId(),
                userDBEntity.getEmail(), userDBEntity.isActive(), new Role(userDBEntity.getRole()), userDBEntity.getPassword());
    }

    public UserDBEntity toDBEntity(UserEmployee userEmployee, RoleDBEntity role, EmployeeDBEntity employeeDBEntity){
        if (userEmployee == null) return null;

        return UserDBEntity.builder()
                .email(userEmployee.getEmail())
                .employee(employeeDBEntity)
                .active(true)
                .password(userEmployee.getPassword())
                .role(role)
                .build();
    }
}
