package com.eat.sleep.auth_identity_service.user.application.ports.output.security.jwt;

import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;

public interface GeneratingToken {

    String generateToken(UserEntityDomain userEntityDomain);
}
