package com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.rest;

import com.eat.sleep.auth_identity_service.common.infrastructure.anotation.WebAdapter;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.CreatingEmployeeInputPort;
import com.eat.sleep.auth_identity_service.employee.application.usecase.dto.CreateEmployeeDto;
import com.eat.sleep.auth_identity_service.employee.domain.model.Employee;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.dto.CreateEmployeeRequestDto;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.dto.CreateEmployeeResponseDto;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.mapper.CreateEmployeeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/employee/")
@WebAdapter
@RequiredArgsConstructor
public class EmployeeControllerAdapter {

    private final CreatingEmployeeInputPort creatingEmployeeInputPort;
    private final CreateEmployeeMapper createEmployeeMapper;

    @PostMapping()
    @Transactional
    public ResponseEntity<CreateEmployeeResponseDto> createUserEmployee(@RequestBody @Valid CreateEmployeeRequestDto createEmployeeRequestDto) {

        // Convert the request DTO to a domain object
        CreateEmployeeDto createEmployeeDto = createEmployeeRequestDto.toDomain();

        Employee employee = this.creatingEmployeeInputPort.createEmployee(createEmployeeDto);

        CreateEmployeeResponseDto createEmployeeResponseDto = this.createEmployeeMapper.toResponseDto(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createEmployeeResponseDto);
    }
}
