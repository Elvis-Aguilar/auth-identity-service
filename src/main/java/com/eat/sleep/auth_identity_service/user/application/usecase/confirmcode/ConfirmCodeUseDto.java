package com.eat.sleep.auth_identity_service.user.application.usecase.confirmcode;

import com.eat.sleep.auth_identity_service.user.domain.model.UserConfirm;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ConfirmCodeUseDto {

    private String email;
    private String code;

    public UserConfirm toDomain(){
        return new UserConfirm(email, code);
    }
}
