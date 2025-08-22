package com.eat.sleep.auth_identity_service.user.application.ports.output.notification;

public interface ConfirmCode {
    boolean confirmCode(String email, String code);
}
