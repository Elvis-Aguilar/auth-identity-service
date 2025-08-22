package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.notifcation.email;

import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.ConfirmCode;
import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.ExistsCode;
import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.GenerateCodeConfirm;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

@Component
@RequiredArgsConstructor
public class CodeConfirmation implements GenerateCodeConfirm, ConfirmCode, ExistsCode {
    private final GoogleAuthenticator googleAuth;
    private final ConcurrentMap<String, String> emailConfirmationCodes;

    @Override
    public boolean confirmCode(String email, String code) {
        emailConfirmationCodes.remove(email);
        return true;
    }

    @Override
    public boolean existsCode(String email, String code) {
        return Objects.equals(emailConfirmationCodes.get(email), code);
    }

    @Override
    public String generateConfirmCode(String email) {
        GoogleAuthenticatorKey credentials = googleAuth.createCredentials();
        String code = String.format("%06d", googleAuth.getTotpPassword(credentials.getKey()));
        emailConfirmationCodes.put(email, code);
        return code;
    }
}
