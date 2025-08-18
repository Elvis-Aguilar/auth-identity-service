package com.eat.sleep.auth_identity_service.user.application.ports.output.notification;

import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;

public interface ConfirmationRegisterUseNotificationPort {
    void notifyConfirmRegister(UserEmployee userEmployee);
}
