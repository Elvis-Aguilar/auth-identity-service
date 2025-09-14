package com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence;


import com.eat.sleep.auth_identity_service.common.infrastructure.annotation.PersistenceAdapter;
import com.eat.sleep.auth_identity_service.common.infrastructure.exception.BadRequestException;
import com.eat.sleep.auth_identity_service.customer.application.ports.output.FindCustomerByIdOutputPort;
import com.eat.sleep.auth_identity_service.customer.application.ports.output.FindingAllCustomersOutputPort;
import com.eat.sleep.auth_identity_service.customer.domain.CustomerDomainEntity;
import com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.entity.CustomerDBEntity;
import com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.mapper.CustomerMapperRepository;
import com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.repository.CustomerDBRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class CustomersRepositoryOutputAdapter implements FindingAllCustomersOutputPort, FindCustomerByIdOutputPort {

    private final CustomerDBRepository customerDBRepository;
    private final CustomerMapperRepository mapper;

    @Override
    public List<CustomerDomainEntity> findAllCustomers() {
        return customerDBRepository.findAll()
                .stream()
                .map(mapper::toDomainEntity)
                .toList();
    }

    @Override
    public CustomerDomainEntity findCustomerById(UUID id) {
        CustomerDBEntity dbEntity = customerDBRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("cliente No encontrado"));

        return mapper.toDomainEntity(dbEntity);
    }
}
