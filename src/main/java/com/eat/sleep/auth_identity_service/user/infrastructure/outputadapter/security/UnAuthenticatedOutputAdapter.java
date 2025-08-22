package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.security;
import static org.springframework.security.authentication.UsernamePasswordAuthenticationToken.unauthenticated;

import com.eat.sleep.auth_identity_service.user.application.ports.output.security.UnAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnAuthenticatedOutputAdapter implements UnAuthenticated {

    @Override
    public Authentication unauthenticatedUser(String email, String password) {
        return unauthenticated(email, password);
    }
}
