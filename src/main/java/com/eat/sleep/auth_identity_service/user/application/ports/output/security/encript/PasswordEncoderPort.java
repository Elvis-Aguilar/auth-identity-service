package com.eat.sleep.auth_identity_service.user.application.ports.output.security.encript;

public interface PasswordEncoderPort {
    String encode(String rawPassword);
}