package com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.mapper;

import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toDomain(EmployeeDBEntity employeeDBEntity){
        if (employeeDBEntity == null) return null;

        return new Employee(employeeDBEntity.getId(),
                employeeDBEntity.getFullName(),
                employeeDBEntity.getCui(),
                employeeDBEntity.getPhone(),
                employeeDBEntity.getEmail(),
                employeeDBEntity.getJobPosition(),
                employeeDBEntity.getSalary(),
                employeeDBEntity.getAddress(),
                employeeDBEntity.getHotelId(),
                employeeDBEntity.getRestaurantId());
    }

    public EmployeeDBEntity toDBEntity(Employee employee){

        if (employee == null) return null;

        return EmployeeDBEntity
                .builder()
                .email(employee.getEmail())
                .cui(employee.getCui())
                .RestaurantId(employee.getRestaurantId())
                .address(employee.getAddress())
                .fullName(employee.getFullName())
                .salary(employee.getSalary())
                .phone(employee.getPhone())
                .jobPosition(employee.getJobPosition())
                .HotelId(employee.getHotelId())
                .build();

    }

}
