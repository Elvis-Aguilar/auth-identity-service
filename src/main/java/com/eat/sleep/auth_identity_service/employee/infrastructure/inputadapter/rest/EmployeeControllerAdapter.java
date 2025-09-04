package com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.rest;

import com.eat.sleep.auth_identity_service.common.infrastructure.annotation.WebAdapter;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.CreatingEmployeeInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.ListingAllEmployeesInputPort;
import com.eat.sleep.auth_identity_service.employee.application.ports.input.ListingAllEmployeesNoManagersInputPort;
import com.eat.sleep.auth_identity_service.employee.application.usecase.dto.CreateEmployeeDto;
import com.eat.sleep.auth_identity_service.employee.domain.model.EmployeeDomainEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.dto.CreateEmployeeRequestDto;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.dto.CreateEmployeeResponseDto;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.dto.EmployeeResponseDto;
import com.eat.sleep.auth_identity_service.employee.infrastructure.inputadapter.mapper.CreateEmployeeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
@WebAdapter
@RequiredArgsConstructor
public class EmployeeControllerAdapter {

    private final CreatingEmployeeInputPort creatingEmployeeInputPort;
    private final CreateEmployeeMapper createEmployeeMapper;
    private final ListingAllEmployeesNoManagersInputPort listingAllEmployeesNoManagersInputPort;
    private final ListingAllEmployeesInputPort listingAllEmployeesInputPort;

    @PostMapping()
    @Transactional
    public ResponseEntity<CreateEmployeeResponseDto> createUserEmployee(@RequestBody @Valid CreateEmployeeRequestDto createEmployeeRequestDto) {

        // Convert the request DTO to a domain object
        CreateEmployeeDto createEmployeeDto = createEmployeeRequestDto.toDomain();

        EmployeeDomainEntity employee = this.creatingEmployeeInputPort.createEmployee(createEmployeeDto);

        CreateEmployeeResponseDto createEmployeeResponseDto = this.createEmployeeMapper.toResponseDto(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createEmployeeResponseDto);
    }

    @GetMapping("/all/no-manager")
    public ResponseEntity<List<EmployeeResponseDto>> findAllEmployeesNoManger() {
        List<EmployeeResponseDto> employees = this.listingAllEmployeesNoManagersInputPort.listAllEmployeesNoManagers()
                .stream()
                .map(createEmployeeMapper::toFindResponseDto)
                .toList();
        return ResponseEntity.ok(employees);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeResponseDto>> findAllEmployees() {
        List<EmployeeResponseDto> employees = this.listingAllEmployeesInputPort.findAllEmployees()
                .stream()
                .map(createEmployeeMapper::toFindResponseDto)
                .toList();
        return ResponseEntity.ok(employees);
    }

}
