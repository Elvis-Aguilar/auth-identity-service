package com.eat.sleep.auth_identity_service.user.application.ports.output.persistence;

import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployeeEntityDomain;

import java.util.Optional;

public interface FindingUserEmployeeByEmailAndRoleOutputPort {
    Optional<UserEmployeeEntityDomain> findByEmailAndRole(String email, String role);
}
