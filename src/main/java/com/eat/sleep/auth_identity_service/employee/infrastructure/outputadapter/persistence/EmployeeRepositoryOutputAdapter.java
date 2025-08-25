package com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence;

import com.eat.sleep.auth_identity_service.common.infrastructure.anotation.PersistenceAdapter;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingAllEmployeesNoMangerOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByCuiOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByEmailOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.StoringEmployeeOutputPort;
import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.mapper.EmployeeMapper;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.repository.EmployeeDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class EmployeeRepositoryOutputAdapter implements FindingEmployeeByEmailOutputPort, FindingEmployeeByCuiOutputPort,
        StoringEmployeeOutputPort, FindingAllEmployeesNoMangerOutputPort {

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
}
