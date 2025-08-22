package com.eat.sleep.auth_identity_service.user.application.usecase.authentication;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AuthUserDto {
    String email;
    String password;
}
