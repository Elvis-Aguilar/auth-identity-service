package com.eat.sleep.auth_identity_service.customer.infrastructure.inputadapter.rest;

import com.eat.sleep.auth_identity_service.common.infrastructure.annotation.WebAdapter;
import com.eat.sleep.auth_identity_service.customer.application.ports.input.FindCustomerByIdInputPort;
import com.eat.sleep.auth_identity_service.customer.application.ports.input.ListAllCustomersInputPort;
import com.eat.sleep.auth_identity_service.customer.infrastructure.inputadapter.dto.CustomerResponseDto;
import com.eat.sleep.auth_identity_service.customer.infrastructure.inputadapter.mapper.CustomerMapperRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/customers")
@WebAdapter
@RequiredArgsConstructor
public class CustomerControllerAdapter {

    private final ListAllCustomersInputPort  listAllCustomersInputPort;
    private final CustomerMapperRest mapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    @GetMapping()
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomer(){
        List<CustomerResponseDto> customerResponseDtos = listAllCustomersInputPort.ListAllCustomers()
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(customerResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable UUID id){
        CustomerResponseDto dto = mapper.toResponseDto(findCustomerByIdInputPort.getCustomerById(id));
        return ResponseEntity.ok(dto);
    }
}
