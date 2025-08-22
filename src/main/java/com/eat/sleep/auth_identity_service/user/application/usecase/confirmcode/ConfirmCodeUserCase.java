package com.eat.sleep.auth_identity_service.user.application.usecase.confirmcode;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.common.infrastructure.exception.FailedAuthenticateException;
import com.eat.sleep.auth_identity_service.user.application.ports.input.ConfirmationCodeInputPort;
import com.eat.sleep.auth_identity_service.user.application.ports.output.security.jwt.GeneratingToken;
import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.ConfirmCode;
import com.eat.sleep.auth_identity_service.user.application.ports.output.persistence.FindingUserByEmailOutputPort;
import com.eat.sleep.auth_identity_service.user.domain.model.UserConfirm;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

@UseCase
@Validated
@RequiredArgsConstructor
public class ConfirmCodeUserCase implements ConfirmationCodeInputPort {

    private final ConfirmCode confirmCode;
    private final FindingUserByEmailOutputPort findingUserByEmailOutputPort;
    private final GeneratingToken generatingToken;

    @Override
    public UserEntityDomain confirmCode(ConfirmCodeUseDto confirmCodeUseDto) {

        UserConfirm userConfirm = confirmCodeUseDto.toDomain();

        boolean confirmed = confirmCode.confirmCode(userConfirm.getEmail(),
                userConfirm.getCode());

        if (!confirmed) {
            throw new FailedAuthenticateException("No se pudo confirmar la cuenta");
        }

        return findingUserByEmailOutputPort.findByEmail(userConfirm.getEmail())
                .map(user -> { user.setToken(generatingToken.generateToken(user)); return user; })
                .orElseThrow(() -> new InsufficientAuthenticationException("No se encontro el registro del usuario"));

    }
}
