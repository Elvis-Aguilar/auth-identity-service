package com.eat.sleep.auth_identity_service.user.application.ports.output.notification;

public interface GenerateCodeConfirm {
    String generateConfirmCode(String key);
}
