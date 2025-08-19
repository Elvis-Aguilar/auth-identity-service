package com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.mapper;

import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.dto.CreateEmployeeResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CreateEmployeeMapper {


    public CreateEmployeeResponseDto toResponseDto(Employee employee){
        if (employee == null) {
            return null;
        }

        return CreateEmployeeResponseDto.builder()
                .id(employee.getId())
                .fullName(employee.getFullName())
                .email(employee.getEmail())
                .cui(employee.getCui())
                .phone(employee.getPhone())
                .jobPosition(employee.getJobPosition())
                .salary(employee.getSalary())
                .address(employee.getAddress())
                .hotelId(employee.getHotelId())
                .restaurantId(employee.getRestaurantId())
                .build();
    }

}
