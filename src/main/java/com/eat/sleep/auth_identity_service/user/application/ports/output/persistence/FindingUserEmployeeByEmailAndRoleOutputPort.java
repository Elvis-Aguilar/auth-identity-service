package com.eat.sleep.auth_identity_service.user.application.ports.output.persistence;

import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;

import java.util.Optional;

public interface FindingUserEmployeeByEmailAndRoleOutputPort {
    Optional<UserEmployee> findByEmailAndRole(String email, String role);
}
