package com.eat.sleep.auth_identity_service.user.application.usecase.authentication;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.user.application.ports.input.AuthenticatingUserInputPort;
import com.eat.sleep.auth_identity_service.user.application.ports.output.persistence.FindingUserByEmailOutputPort;
import com.eat.sleep.auth_identity_service.user.application.ports.output.security.UnAuthenticated;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


@UseCase
@Validated
@RequiredArgsConstructor
public class AuthenticationUserCase implements AuthenticatingUserInputPort {

    private final UnAuthenticated unAuthenticated;
    private final AuthenticationManager authenticationManager;
    private final FindingUserByEmailOutputPort findingUserByEmailOutputPort;


    @Override
    @Transactional
    public UserEntityDomain authenticationUser(AuthUserDto authUserDto) {
        authenticationManager.authenticate(unAuthenticated.unauthenticatedUser(authUserDto.getEmail(), authUserDto.getPassword()));

        UserEntityDomain userEntityDomain = findingUserByEmailOutputPort.findByEmail(authUserDto.getEmail())
                .orElseThrow(() -> new InsufficientAuthenticationException("No se encontro el registro del usuario"));

        return userEntityDomain;
    }
}
