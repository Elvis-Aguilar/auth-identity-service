package com.eat.sleep.auth_identity_service.user.application.ports.input;

import com.eat.sleep.auth_identity_service.user.application.usecase.createuseremployee.CreateUserEmployeeDto;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;
import jakarta.validation.Valid;

public interface CreatingUserEmployeeInputPort {
    UserEmployee createUserEmployee(@Valid CreateUserEmployeeDto createUserEmployeeDto);
}
