package com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto;

import com.eat.sleep.auth_identity_service.user.application.usecase.confirmcode.ConfirmCodeUseDto;
import com.eat.sleep.auth_identity_service.user.application.usecase.createuseremployee.CreateUserEmployeeDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class ConfirmUserDto{

    @NotBlank String email;
    @NotBlank String code;

    public ConfirmCodeUseDto toDomain(){
        return new ConfirmCodeUseDto(email, code);
    }
}
