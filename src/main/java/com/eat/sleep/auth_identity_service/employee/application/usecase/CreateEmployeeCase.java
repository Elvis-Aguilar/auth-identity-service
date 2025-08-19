package com.eat.sleep.auth_identity_service.employee.application.usecase;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.common.application.exception.EntityAlreadyExistsException;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.CreatingEmployeeInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByCuiOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByEmailOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.StoringEmployeeOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.usecase.dto.CreateEmployeeDto;
import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@UseCase
@Validated
@RequiredArgsConstructor
public class CreateEmployeeCase implements CreatingEmployeeInputPort {

    private final StoringEmployeeOutputPort storingEmployeeOutputPort;
    private final FindingEmployeeByEmailOutputPort findingEmployeeByEmailOutputPort;
    private final FindingEmployeeByCuiOutputPort findingEmployeeByCuiOutputPort;

    @Override
    @Transactional
    public Employee createEmployee(CreateEmployeeDto createEmployeeDto) {

        // validar que no exista otro empleado con ese email
        if (this.findingEmployeeByEmailOutputPort.findByEmployeeByEmail(createEmployeeDto.getEmail()).isPresent()){
            throw new EntityAlreadyExistsException("Empleado ya existente con ese correo");
        }

        // validar cui
        if (this.findingEmployeeByCuiOutputPort.findByEmployeeByCui(createEmployeeDto.getCui()).isPresent()){
            throw new EntityAlreadyExistsException("Empleado ya existente con ese CUI");
        }

        // crear empleado
        Employee newEmployee = createEmployeeDto.toDomain();

        // persistencia
        Employee savedEmployee = this.storingEmployeeOutputPort.save(newEmployee);

        return savedEmployee;
    }
}
