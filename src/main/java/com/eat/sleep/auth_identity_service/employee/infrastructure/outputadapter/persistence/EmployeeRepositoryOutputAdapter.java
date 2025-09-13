package com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence;

import com.eat.sleep.auth_identity_service.common.infrastructure.annotation.PersistenceAdapter;
import com.eat.sleep.auth_identity_service.common.infrastructure.exception.BadRequestException;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.*;
import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.mapper.EmployeeMapper;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.repository.EmployeeDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class EmployeeRepositoryOutputAdapter implements FindingEmployeeByEmailOutputPort, FindingEmployeeByCuiOutputPort,
        StoringEmployeeOutputPort, FindingAllEmployeesNoMangerOutputPort, FindingAllEmployeesOutputPort, FindingEmployeeIdOutputPort {

    private final EmployeeDBRepository employeeDBRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<EmployeeDomainEntity> findByEmployeeByEmail(String email) {
        return this.employeeDBRepository.findByEmail(email)
                .map(employeeMapper::toDomain);
    }

    @Override
    @Transactional
    public EmployeeDomainEntity save(EmployeeDomainEntity employee) {

        EmployeeDBEntity employeeDBEntity = this.employeeDBRepository.save(this.employeeMapper.toDBEntity(employee));

        return this.employeeMapper.toDomain(employeeDBEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmployeeDomainEntity> findByEmployeeByCui(String cui) {
        return this.employeeDBRepository.findByCui(cui)
                .map(employeeMapper::toDomain);
    }

    @Override
    public List<EmployeeDomainEntity> findAllEmployeesNoManger() {
        return this.employeeDBRepository.findAllByJobPositionNot("GERENTE")
                .stream()
                .map(employeeMapper::toDomain)
                .toList();
    }

    @Override
    public List<EmployeeDomainEntity> findAllEmployees() {
        return this.employeeDBRepository.findAll()
                .stream()
                .map(employeeMapper::toDomain)
                .toList();
    }

    @Override
    public EmployeeDomainEntity findByEmployeeById(UUID Id) {
        EmployeeDBEntity dbEntity = this.employeeDBRepository.findById(Id)
                .orElseThrow(() -> new BadRequestException("Empleado no encontrado"));

        return employeeMapper.toDomain(dbEntity);
    }
}
