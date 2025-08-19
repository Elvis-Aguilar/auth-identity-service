package com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.mapper;

import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto.UserEmployeeResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserEmployeeMapper {

    public UserEmployeeResponseDto toResponseDto(UserEmployee userEmployee){
        if (userEmployee == null) {
            return null;
        }

        return UserEmployeeResponseDto.builder()
                .id(userEmployee.getId())
                .employeeId(userEmployee.getEmployeeId())
                .role(userEmployee.getRole())
                .email(userEmployee.getEmail())
                .active(userEmployee.isActive())
                .build();
    }
}
