package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence;

import com.eat.sleep.auth_identity_service.common.infrastructure.anotation.PersistenceAdapter;
import com.eat.sleep.auth_identity_service.common.infrastructure.exception.FailedAuthenticateException;
import com.eat.sleep.auth_identity_service.user.application.ports.output.persistence.FindingUserByEmailOutputPort;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.entity.UserDBEntity;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.mapper.UserMapper;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.repository.UserDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserRepositoryOutputAdapter implements FindingUserByEmailOutputPort {

    private final UserDBRepository userDBRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntityDomain> findByEmail(String email) {
        return this.userDBRepository.findByEmail(email, UserDBEntity.class)
                .map(userMapper::toDomain);
    }
}
