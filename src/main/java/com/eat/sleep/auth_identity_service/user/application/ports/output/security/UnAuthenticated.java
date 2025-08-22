package com.eat.sleep.auth_identity_service.user.application.ports.output.security;
import org.springframework.security.core.Authentication;

public interface UnAuthenticated {
    Authentication unauthenticatedUser(String email, String password);
}
