package com.eat.sleep.auth_identity_service.employee.application.usecase;

import com.eat.sleep.auth_identity_service.common.application.annotations.UseCase;
import com.eat.sleep.auth_identity_service.common.application.exception.EntityAlreadyExistsException;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.CreatingEmployeeInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByCuiOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.FindingEmployeeByEmailOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.output.StoringEmployeeOutputPort;
import com.eat.sleep.auth_identity_service.employee.application.usecase.dto.CreateEmployeeDto;
import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
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
    public EmployeeDomainEntity createEmployee(CreateEmployeeDto createEmployeeDto) {

        // validar que no exista otro empleado con ese email
        if (this.findingEmployeeByEmailOutputPort.findByEmployeeByEmail(createEmployeeDto.getEmail()).isPresent()){
            throw new EntityAlreadyExistsException("Empleado ya existente con ese correo");
        }

        // validar que el cui del empleado no exista
        if (this.findingEmployeeByCuiOutputPort.findByEmployeeByCui(createEmployeeDto.getCui()).isPresent()){
            throw new EntityAlreadyExistsException("Empleado ya existente con ese CUI");
        }

        // crear empleado
        EmployeeDomainEntity newEmployee = createEmployeeDto.toDomain();

        // validaciones tambien son output ports, consultando micros servicio de hoteles y restaurantes
        if (newEmployee.isAssignedToHotel()){
            //TODO: validar que el hotel exista
        }else{
            //TODO: validar que el restaurante exista
        }

        // persistencia
        EmployeeDomainEntity savedEmployee = this.storingEmployeeOutputPort.save(newEmployee);

        return savedEmployee;
    }
}
