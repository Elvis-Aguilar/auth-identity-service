package com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence;

import com.eat.sleep.auth_identity_service.common.infrastructure.anotation.PersistenceAdapter;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByCuiOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByEmailOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.StoringEmployeeOutputPort;
import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.mapper.EmployeeMapper;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.repository.EmployeeDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class EmployeeRepositoryOutputAdapter implements FindingEmployeeByEmailOutputPort, FindingEmployeeByCuiOutputPort, StoringEmployeeOutputPort {

    private final EmployeeDBRepository employeeDBRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findByEmployeeByEmail(String email) {
        return this.employeeDBRepository.findByEmail(email)
                .map(employeeMapper::toDomain);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        EmployeeDBEntity employeeDBEntity = this.employeeDBRepository.save(this.employeeMapper.toDBEntity(employee));

        return this.employeeMapper.toDomain(employeeDBEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findByEmployeeByCui(String cui) {
        return this.employeeDBRepository.findByCui(cui)
                .map(employeeMapper::toDomain);
    }
}
