package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.mapper;

import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.entity.RoleDBEntity;
import com.eat.sleep.auth_identity_service.user.domain.model.Role;
import com.eat.sleep.auth_identity_service.user.domain.model.UserCustomerEntityDomain;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployeeEntityDomain;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.entity.UserDBEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntityDomain toDomain(UserDBEntity userDBEntity){
        if (userDBEntity == null) return null;

        if ( userDBEntity.getRole().getName().equalsIgnoreCase("CLIENTE")){
            return this.toDomainUserCustomer(userDBEntity);
        }

        return this.toDomainUserEmployee(userDBEntity);
    }

    public UserEmployeeEntityDomain toDomainUserEmployee(UserDBEntity userDBEntity){

        if (userDBEntity == null) return null;

        return new UserEmployeeEntityDomain(userDBEntity.getId(),
                userDBEntity.getEmployee().getId(),
                userDBEntity.getEmail(), userDBEntity.isActive(), new Role(userDBEntity.getRole()), userDBEntity.getPassword());
    }

    public UserCustomerEntityDomain toDomainUserCustomer(UserDBEntity userDBEntity){

        if (userDBEntity == null) return null;

        return new UserCustomerEntityDomain(userDBEntity.getId(),
                userDBEntity.getCustomer().getId(),
                userDBEntity.getEmail(), userDBEntity.isActive(), new Role(userDBEntity.getRole()), userDBEntity.getPassword());
    }

    public UserDBEntity toDBEntity(UserEmployeeEntityDomain userEmployee, RoleDBEntity role, EmployeeDBEntity employeeDBEntity){
        if (userEmployee == null) return null;

        return UserDBEntity.builder()
                .email(userEmployee.getEmail())
                .employee(employeeDBEntity)
                .customer(null)
                .active(true)
                .password(userEmployee.getPassword())
                .role(role)
                .build();
    }
}
