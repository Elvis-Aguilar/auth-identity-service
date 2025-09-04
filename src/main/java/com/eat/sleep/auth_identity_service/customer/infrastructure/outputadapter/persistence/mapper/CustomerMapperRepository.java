package com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.mapper;

import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;
import com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.entity.CustomerDBEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperRepository {

    public CustomerDomainEntity toDomainEntity(CustomerDBEntity customerDBEntity) {
        return new CustomerDomainEntity(customerDBEntity.getId(),
                customerDBEntity.getFullName(),
                customerDBEntity.getEmail(),
                customerDBEntity.getPhone(),
                customerDBEntity.getAddress(),
                customerDBEntity.getCui(),
                customerDBEntity.getLoyaltyPoints()
                );
    }
}
