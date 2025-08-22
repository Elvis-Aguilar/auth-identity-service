package com.eat.sleep.auth_identity_service.user.application.ports.input;

import com.eat.sleep.auth_identity_service.user.application.usecase.authentication.AuthUserDto;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;

public interface AuthenticatingUserInputPort {
    UserEntityDomain authenticationUser(AuthUserDto authUserDto);
}
