package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence;

import com.eat.sleep.auth_identity_service.common.application.exception.EntityNotFount;
import com.eat.sleep.auth_identity_service.common.application.exception.RoleNotExist;
import com.eat.sleep.auth_identity_service.common.infrastructure.anotation.PersistenceAdapter;
import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.mapper.EmployeeMapper;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.repository.EmployeeDBRepository;
import com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.entity.RoleDBEntity;
import com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.repository.RoleDBRepository;
import com.eat.sleep.auth_identity_service.user.application.ports.output.persistence.FindingUserEmployeeByEmailAndRoleOutputPort;
import com.eat.sleep.auth_identity_service.user.application.ports.output.persistence.StoringUserEmployeeOutputPort;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployee;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.entity.UserDBEntity;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.mapper.UserMapper;
import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.repository.UserDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserEmployeeRepositoryOutputAdapter implements FindingUserEmployeeByEmailAndRoleOutputPort, StoringUserEmployeeOutputPort {

    private final UserDBRepository userDBRepository;
    private final UserMapper userMapper;
    private final RoleDBRepository roleDBRepository;
    private final EmployeeDBRepository employeeDBRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEmployee> findByEmailAndRole(String email, String role) {
        return this.userDBRepository.findByEmailAndRole_name(email,role)
                .map(userMapper::toDomain);
    }

    @Override
    public UserEmployee save(UserEmployee userEmployee, Employee employee) {
        RoleDBEntity roleDBEntity = this.roleDBRepository.findByName(userEmployee.getRole().getName())
                .orElseThrow(()-> new RoleNotExist("No existe el rol para el empleado"));

        EmployeeDBEntity employeeDBEntity = this.employeeMapper.toDBEntity(employee);

        UserDBEntity userDBEntity = this.userDBRepository.save(this.userMapper.toDBEntity(userEmployee, roleDBEntity, employeeDBEntity));

        return this.userMapper.toDomain(userDBEntity);
    }
}
