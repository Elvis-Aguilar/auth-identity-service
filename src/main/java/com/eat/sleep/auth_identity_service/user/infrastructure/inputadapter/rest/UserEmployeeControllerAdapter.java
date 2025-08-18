package com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.rest;


import com.eat.sleep.auth_identity_service.common.infrastructure.anotation.WebAdapter;
import com.eat.sleep.auth_identity_service.user.application.ports.input.CreatingUserEmployeeInputPort;
import com.eat.sleep.auth_identity_service.user.application.usecase.createuseremployee.CreateUserEmployeeDto;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto.UserEmployeeRequest;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto.UserEmployeeResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/user/employee/auth")
@WebAdapter
@RequiredArgsConstructor
public class UserEmployeeControllerAdapter {

    private final CreatingUserEmployeeInputPort creatingUserEmployeeInputPort;

    @PostMapping("/sign-up")
    @Transactional
    public ResponseEntity<UserEmployeeResponseDto> creatRegisterUserEmployee(@RequestBody @Valid UserEmployeeRequest createUserRequest) {
        CreateUserEmployeeDto objectAdapterFromToDomain = createUserRequest.toDomain();

        UserEmployee userEmployee = this.creatingUserEmployeeInputPort.createUserEmployee(objectAdapterFromToDomain);

        UserEmployeeResponseDto userEmployeeResponse = UserEmployeeResponseDto.builder()
                .id(userEmployee.getId())
                .employeeId(userEmployee.getEmployeeId())
                .role(userEmployee.getRole())
                .email(userEmployee.getEmail())
                .active(userEmployee.isActive())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(userEmployeeResponse);
    }

}
