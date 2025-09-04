package com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.repository;

import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;
import com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.entity.CustomerDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerDBRepository extends JpaRepository<CustomerDBEntity, UUID> {
}
