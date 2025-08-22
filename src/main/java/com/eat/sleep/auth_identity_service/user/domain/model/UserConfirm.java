package com.eat.sleep.auth_identity_service.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserConfirm {
    private String email;
    private String code;
}
