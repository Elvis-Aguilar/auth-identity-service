package com.eat.sleep.auth_identity_service.user.application.ports.output.persistence;

import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;

import java.util.Optional;

public interface FindingUserByEmailOutputPort {
    Optional<UserEntityDomain> findByEmail(String email);
}
