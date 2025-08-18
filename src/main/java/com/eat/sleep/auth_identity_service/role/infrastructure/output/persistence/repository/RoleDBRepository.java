package com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.repository;

import com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.entity.RoleDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleDBRepository extends JpaRepository<RoleDBEntity, Long> {

     Optional<RoleDBEntity> findByName(String name);

}
